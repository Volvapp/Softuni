package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        switch (areaType) {
            case "WaterArea":
                areas.add(new WaterArea(areaName));
                break;
            case "LandArea":
                areas.add(new LandArea(areaName));
                break;
            default:
                throw new NullPointerException(INVALID_AREA_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        switch (foodType) {
            case "Vegetable":
                foodRepository.add(new Vegetable());
                break;
            case "Meat":
                foodRepository.add(new Meat());
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Area currentArea = this.areas.stream().filter(a -> a.getName().equals(areaName)).findFirst().orElse(null);
        if (foodType.equals("Meat")) {
            currentArea.addFood(new Meat());
        } else if (foodType.equals("Vegetable")) {
            currentArea.addFood(new Vegetable());
        } else {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Area currentArea = areas.stream().filter(area -> area.getName().equals(areaName)).findFirst().orElse(null);
        switch (animalType) {
            case "AquaticAnimal":
                if (currentArea.getClass().getSimpleName().equals("WaterArea")) {
                    currentArea.addAnimal(new AquaticAnimal(animalName, kind, price));
                } else {
                    return AREA_NOT_SUITABLE;
                }
                break;
            case "TerrestrialAnimal":
                if (currentArea.getClass().getSimpleName().equals("LandArea")) {
                    currentArea.addAnimal(new TerrestrialAnimal(animalName, kind, price));
                } else {
                    return AREA_NOT_SUITABLE;
                }
                break;
            default:
                throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area currentArea = areas.stream().filter(area -> area.getName().equals(areaName)).findFirst().orElse(null);
        currentArea.feed();
        return String.format(ANIMALS_FED, currentArea.getAnimals().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area currentArea = areas.stream().filter(area -> area.getName().equals(areaName)).findFirst().orElse(null);
        return String.format(KILOGRAMS_AREA,areaName, currentArea.getAnimals().stream().mapToDouble(Animal::getKg).sum());
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Area a : areas) {
            sb.append(a.getInfo()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
