package DefiningClassesExercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carList = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tyrePressure = Double.parseDouble(input[5]);
            int tyreAge = Integer.parseInt(input[6]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tyrePressure, tyreAge);



            carList.add(car);

        }
        String command = scanner.nextLine();

        if (command.equals("fragile")){
            carList = carList.stream().filter(car -> car.getCargoType().equals("fragile")).collect(Collectors.toList());
            carList = carList.stream().filter(car -> car.getTirePressure() <= 1).collect(Collectors.toList());

        }else if (command.equals("flamable")){
            carList = carList.stream().filter(car -> car.getCargoType().equals("flamable")).collect(Collectors.toList());
            carList = carList.stream().filter(car -> car.getEnginePower() > 250).collect(Collectors.toList());

        }

        carList.forEach(car -> System.out.print(car.toString()));
    }
}
