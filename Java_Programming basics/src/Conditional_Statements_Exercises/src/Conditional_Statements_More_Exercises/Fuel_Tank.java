package Conditional_Statements_More_Exercises;

import java.util.Scanner;

public class Fuel_Tank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfFuel = scanner.nextLine();
        int liters = Integer.parseInt(scanner.nextLine());
        //"Diesel", "Gasoline" или "Gas"

        switch (typeOfFuel) {
            case "Diesel":
                if (liters >= 25) {
                    System.out.println("You have enough diesel.");
                } else {
                    System.out.println("Fill your tank with diesel!");
                }
                break;
            case "Gasoline":
                if (liters >= 25) {
                    System.out.println("You have enough gasoline.");
                } else {
                    System.out.println("Fill your tank with gasoline!");
                }
                break;
            case "Gas":
                if (liters >= 25) {
                    System.out.println("You have enough gas.");
                    break;
                } else {
                    System.out.println("Fill your tank with gas!");
                    break;
                }
            default:
                System.out.println("Invalid fuel!");
                break;
        }
    }
}


