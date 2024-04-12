package exercisesPolymorphism.Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        if (this.getClass().getSimpleName().equals("Car")) {
            this.fuelConsumption = fuelConsumption + 0.9;
        } else if (this.getClass().getSimpleName().equals("Truck")) {
            this.fuelConsumption = fuelConsumption + 1.6;
        }

    }

    @Override
    public String toString() {

        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
