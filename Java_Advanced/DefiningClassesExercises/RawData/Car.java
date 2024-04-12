package DefiningClassesExercise.RawData;

public class Car {

    private String model;
    private int engineSpeed;
    private int enginePower;
    private int cargoWeight;
    private String cargoType;
    private double tirePressure;
    private int tireAge;

    public String getModel() {
        return model;
    }

    public int getEnginePower() {
        return enginePower;
    }



    public String getCargoType() {
        return cargoType;
    }

    public double getTirePressure() {
        return tirePressure;
    }



    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double tirePressure, int tireAge) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    @Override
    public String toString(){
        return String.format("%BasicStackOperations%n",getModel());
    }
}
