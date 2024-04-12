package DefiningClassesLab.CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carParts = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(carParts[0]);
            car.setModel(carParts[1]);
            car.setHorsepower(Integer.parseInt(carParts[2]));

            System.out.println(car.carInfo());
        }

    }

    public static void test() {
        Car firstCar = new Car();


        firstCar.setBrand("Opel");
        firstCar.setModel("Astra");
        firstCar.setHorsepower(90);


        System.out.println(firstCar.carInfo());
    }
}
