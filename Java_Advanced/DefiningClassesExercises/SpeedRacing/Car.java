package DefiningClassesExercises.SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double priceFuelPerKm;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double priceFuelPerKm) {

        this.model = model;

        this.fuelAmount = fuelAmount;

        this.priceFuelPerKm = priceFuelPerKm;

        this.distanceTravelled = 0;
    }

    public boolean drive(int kmDrive) {
        double neededFuel = kmDrive * priceFuelPerKm;

        if (neededFuel <= this.fuelAmount) {
            this.fuelAmount-= neededFuel;
            this.distanceTravelled += kmDrive;
            return true;

        } else {
            return false;
        }


    }
    @Override
    public String toString (){
        return String.format("%s %.2f %d",this.model, this.fuelAmount, this.distanceTravelled);
    }




























}
