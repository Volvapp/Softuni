package christmasRaces.entities.drivers;

import christmasRaces.entities.cars.Car;

import static christmasRaces.common.ExceptionMessages.CAR_INVALID;
import static christmasRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver{
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        this.setName(name);
        car = null;
        numberOfWins = 0;
        canParticipate = false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < 5){
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        this.name = name;
    }

    @Override
    public Car getCar() {
        return this.car;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null){
            throw new IllegalArgumentException(CAR_INVALID);
        }
        this.car = car;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}
