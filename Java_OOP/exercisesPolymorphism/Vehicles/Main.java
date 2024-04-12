package exercisesPolymorphism.Vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        double carFuel = Double.parseDouble(carInfo[1]);
        double carLitersPerKm = Double.parseDouble(carInfo[2]);

        Vehicle car = new Car(carFuel, carLitersPerKm);

        String[] truckInfo = scanner.nextLine().split("\\s+");
        double truckFuel = Double.parseDouble(truckInfo[1]);
        double truckLitersPerKm = Double.parseDouble(truckInfo[2]);

        Vehicle truck = new Truck(truckFuel, truckLitersPerKm);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            double kmToDrive = Double.parseDouble(commands[2]);

            boolean needsRefuel = false;
            switch (commands[0]) {

                case "Drive":
                    if (commands[1].equals("Car")) {
                        if (car.getFuelQuantity() >= car.getFuelConsumption() * kmToDrive) {
                            double result = car.getFuelQuantity() - (car.getFuelConsumption() * kmToDrive);
                            car.setFuelQuantity(result);
                            printFormat(kmToDrive, commands[1]);
                        } else {
                            needsRefuel = true;
                        }
                    } else if (commands[1].equals("Truck")) {
                        if (truck.getFuelQuantity() >= truck.getFuelConsumption() * kmToDrive) {
                            double result = truck.getFuelQuantity() - (truck.getFuelConsumption() * kmToDrive);
                            truck.setFuelQuantity(result);
                            printFormat(kmToDrive, commands[1]);
                        } else {
                            needsRefuel = true;
                        }
                    }
                    break;
                case "Refuel":
                    double fuel = Double.parseDouble(commands[2]);
                    if (commands[1].equals("Car")) {
                        car.setFuelQuantity(car.getFuelQuantity() + fuel);
                    } else if (commands[1].equals("Truck")) {
                        truck.setFuelQuantity(truck.getFuelQuantity() + (fuel - fuel * 0.05));
                    }
                    break;

            }
            if (needsRefuel) {
                System.out.println(commands[1] + " needs refueling");
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
    }

    private static void printFormat(double result, String typeVehicle) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println(typeVehicle + " travelled " + df.format(result) + " km");
    }

}

