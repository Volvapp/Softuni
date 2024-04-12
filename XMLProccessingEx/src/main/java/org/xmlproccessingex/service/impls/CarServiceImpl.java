package org.xmlproccessingex.service.impls;

import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.xmlproccessingex.data.entities.Car;
import org.xmlproccessingex.data.entities.Part;
import org.xmlproccessingex.data.repositories.CarRepository;
import org.xmlproccessingex.data.repositories.PartRepository;
import org.xmlproccessingex.service.CarService;
import org.xmlproccessingex.service.dtos.CarSeedDto;
import org.xmlproccessingex.service.dtos.CarSeedRootDto;
import org.xmlproccessingex.util.XmlParser;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CarServiceImpl implements CarService {
    private static final String FILE_IMPORT_PATH = "src/main/resources/xml/imports/cars.xml";
    private final CarRepository carRepository;
    private final PartRepository partRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, PartRepository partRepository, XmlParser xmlParser, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCars() throws JAXBException {
        if (this.carRepository.count() == 0) {
            CarSeedRootDto carSeedRootDto = this.xmlParser.parse(CarSeedRootDto.class, FILE_IMPORT_PATH);
            for (CarSeedDto carSeedDto : carSeedRootDto.getCarSeedDtoList()) {
                Car car = this.modelMapper.map(carSeedDto, Car.class);
                car.setParts(getRandomParts());

                this.carRepository.saveAndFlush(car);
            }
        }

    }

    private Set<Part> getRandomParts() {
        Set<Part> parts = new HashSet<>();
        int count = ThreadLocalRandom.current().nextInt(2, 4);

        for (int i = 0; i < count; i++) {
            parts.add(this.partRepository
                    .findById(ThreadLocalRandom.current().nextLong(1, this.partRepository.count() + 1)).get());
        }
        return parts;
    }
}
