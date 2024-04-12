package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.VolkanologistRootDto;
import softuni.exam.models.dto.xml.VolkanologistSeedDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class VolcanologistServiceImpl implements VolcanologistService {
    private static final String FILE_PATH = "src/main/resources/files/xml/volcanologists.xml";
    private final VolcanologistRepository volcanologistRepository;
    private final VolcanoRepository volcanoRepository;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository, VolcanoRepository volcanoRepository, ValidationUtil validationUtil, XmlParser xmlParser, ModelMapper modelMapper) {
        this.volcanologistRepository = volcanologistRepository;
        this.volcanoRepository = volcanoRepository;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.volcanologistRepository.count() > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importVolcanologists() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();
        VolkanologistRootDto volkanologistRootDto = xmlParser.fromFile(FILE_PATH, VolkanologistRootDto.class);
        for (VolkanologistSeedDto volkanologistSeedDto : volkanologistRootDto.getVolkanologistSeedDtoList()) {
            Optional<Volcanologist> optionalVolcanologist = volcanologistRepository.findByFirstNameAndLastName(volkanologistSeedDto.getFirstName(), volkanologistSeedDto.getLastName());
            Optional<Volcano> optionalVolcano = volcanoRepository.findById(volkanologistSeedDto.getVolcanoId());
            if (!this.validationUtil.isValid(volkanologistSeedDto) || optionalVolcanologist.isPresent() || optionalVolcano.isEmpty()){
                sb.append("Invalid volcanologist\n");
                continue;
            }
            Volcanologist volcanologist = this.modelMapper.map(volkanologistSeedDto, Volcanologist.class);
            volcanologist.setExploringVolcano(optionalVolcano.get());
            volcanologistRepository.saveAndFlush(volcanologist);
            sb.append(String.format("Successfully imported volcanologist %s %s\n", volcanologist.getFirstName(), volcanologist.getLastName()));
        }
        return sb.toString().trim();
    }
}