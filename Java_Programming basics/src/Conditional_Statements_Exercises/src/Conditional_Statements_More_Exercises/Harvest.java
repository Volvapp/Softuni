package Conditional_Statements_More_Exercises;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        int z = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        double literWineKg = 2.5; //Кг грозде

        double allGrape = x * y;
        double wine = 0.40 * allGrape / literWineKg;


        double leftWine = (wine - z);
        if (wine >= z) {
            double workersWine = leftWine / workers;
            int floor = (int) Math.floor(wine);
            int ceil1 = (int) Math.ceil(leftWine);
            int ceil2 = (int) Math.ceil(workersWine);
            System.out.printf("Good harvest this year! Total wine: " + floor + " liters.\n" +
                    ceil1 + " liters left -> " + ceil2 + " liters per person.");
        } else {
            int leftWineInt = (int) leftWine;
            int abs = Math.abs(leftWineInt);
            System.out.printf("It will be a tough winter! More " + abs + " liters wine needed.");


        }
    }
}