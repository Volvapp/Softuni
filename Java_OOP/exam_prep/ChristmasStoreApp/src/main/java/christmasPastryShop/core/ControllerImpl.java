package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        totalIncome = 0;

    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        if (delicacyRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        switch (type) {
            case "Gingerbread":
                this.delicacyRepository.add(new Gingerbread(name, price));
                break;
            case "Stolen":
                this.delicacyRepository.add(new Stolen(name, price));
                break;
            default:
                throw new IllegalArgumentException("No such type!");
        }
        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        if (cocktailRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        switch (type) {
            case "Hibernation":
                this.cocktailRepository.add(new Hibernation(name, size, brand));
                break;
            case "MulledWine":
                this.cocktailRepository.add(new MulledWine(name, size, brand));
                break;
            default:
                throw new IllegalArgumentException("Wrong type of cocktail!");
        }
        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        if (boothRepository.getByNumber(boothNumber) != null) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }
        switch (type) {
            case "OpenBooth":
                this.boothRepository.add(new OpenBooth(boothNumber, capacity));
                break;
            case "PrivateBooth":
                this.boothRepository.add(new PrivateBooth(boothNumber, capacity));
                break;
            default:
                throw new IllegalArgumentException("Wrong type of booth!");
        }
        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Booth currentBooth = boothRepository.getAll()
                .stream()
                .filter(booth -> !booth.isReserved() && booth.getCapacity() >= numberOfPeople)
                .findFirst().orElse(null);

        if (currentBooth == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        currentBooth.reserve(numberOfPeople);
        return String.format(BOOTH_RESERVED, currentBooth.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        StringBuilder sb = new StringBuilder();

        Booth currentBooth = boothRepository.getByNumber(boothNumber);
        totalIncome += currentBooth.getBill();

        sb.append(String.format(BILL, boothNumber, currentBooth.getBill()));

        currentBooth.clear();
        return sb.toString().trim();
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }
}
