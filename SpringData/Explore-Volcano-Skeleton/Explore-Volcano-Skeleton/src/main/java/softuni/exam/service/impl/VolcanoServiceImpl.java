package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.json.VolcanoSeedDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.VolcanoService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VolcanoServiceImpl implements VolcanoService {
    private static final String FILE_PATH = "src/main/resources/files/json/volcanoes.json";
    private final VolcanoRepository volcanoRepository;
    private final CountryRepository countryRepository;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;

    public VolcanoServiceImpl(VolcanoRepository volcanoRepository, CountryRepository countryRepository, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.volcanoRepository = volcanoRepository;
        this.countryRepository = countryRepository;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.volcanoRepository.count() > 0;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importVolcanoes() throws IOException {
        StringBuilder sb = new StringBuilder();
        VolcanoSeedDto[] volcanoSeedDtos = this.gson.fromJson(readVolcanoesFileContent(), VolcanoSeedDto[].class);
        for (VolcanoSeedDto volcanoSeedDto : volcanoSeedDtos) {
            Optional<Volcano> optional = volcanoRepository.findByName(volcanoSeedDto.getName());
            if (!this.validationUtil.isValid(volcanoSeedDto) || optional.isPresent()) {
                sb.append("Invalid volcano\n");
                continue;
            }
            Volcano volcano = this.modelMapper.map(volcanoSeedDto, Volcano.class);
            volcano.setCountry(countryRepository.getById(volcanoSeedDto.getCountry()));
            volcanoRepository.saveAndFlush(volcano);
            sb.append(String.format("Successfully imported volcano %s of type %s\n", volcano.getName(), volcano.getVolcanoType()));
        }
        return sb.toString().trim();
    }

    @Override
    public String exportVolcanoes() {
        return volcanoRepository
                .findAllByElevationAfterAndLastEruptionNotNullAndActiveOrderByElevationDesc(3000, true)
                .stream()
                .map(volcano -> String.format("Volcano: %s\n" +
                        "   *Located in: %s\n" +
                        "   **Elevation: %d\n" +
                        "   ***Last eruption on: %s\n",
                        volcano.getName(),
                        volcano.getCountry().getName(),
                        volcano.getElevation(),
                        volcano.getLastEruption()
                )).collect(Collectors.joining());
    }
}