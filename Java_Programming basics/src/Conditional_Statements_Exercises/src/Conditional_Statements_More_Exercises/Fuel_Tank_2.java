package Conditional_Statements_More_Exercises;

import java.util.Scanner;

public class Fuel_Tank_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Бензин – 2.22 лева за един литър,
        //Дизел – 2.33 лева за един литър
        //Газ – 0.93 лева за литър

        String fuelType = scanner.nextLine();
        double fuelLiters = Double.parseDouble(scanner.nextLine());
        String discountCard = scanner.nextLine();
        double fuelPricePerLiter = 0;
        double priceWithLiters = 0;

        switch (fuelType) {
            case "Gas":
                fuelPricePerLiter = 0.93; //per liter
                priceWithLiters = fuelPricePerLiter * fuelLiters;
                if (discountCard.equals("Yes")) {
                    fuelPricePerLiter = fuelPricePerLiter - 0.08;
                    priceWithLiters = fuelPricePerLiter * fuelLiters;
                }
                if (fuelLiters <= 19) {
                    priceWithLiters = priceWithLiters * 1;
                } else if (fuelLiters <= 25) {
                    priceWithLiters = priceWithLiters * 0.92;
                } else if (fuelLiters > 25) {
                    priceWithLiters = priceWithLiters * 0.90;
                }


                System.out.printf("%.2f lv.", priceWithLiters);
                break;
            case "Gasoline":
                fuelPricePerLiter = 2.22; //per liter
                priceWithLiters = fuelPricePerLiter * fuelLiters;
                if (discountCard.equals("Yes")) {
                    fuelPricePerLiter = fuelPricePerLiter - 0.18;
                    priceWithLiters = fuelPricePerLiter * fuelLiters;
                }
                if (fuelLiters <= 19) {
                    priceWithLiters = priceWithLiters * 1;
                } else if (fuelLiters <= 25) {
                    priceWithLiters = priceWithLiters * 0.92;
                } else if (fuelLiters > 25) {
                    priceWithLiters = priceWithLiters * 0.90;
                }


                System.out.printf("%.2f lv.", priceWithLiters);
                break;
            case "Diesel":
                fuelPricePerLiter = 2.33; //per liter
                priceWithLiters = fuelPricePerLiter * fuelLiters;
                if (discountCard.equals("Yes")) {
                    fuelPricePerLiter = fuelPricePerLiter - 0.12;
                    priceWithLiters = fuelPricePerLiter * fuelLiters;
                }
                if (fuelLiters <= 19) {
                    priceWithLiters = priceWithLiters * 1;
                } else if (fuelLiters <= 25) {
                    priceWithLiters = priceWithLiters * 0.92;
                } else if (fuelLiters > 25) {
                    priceWithLiters = priceWithLiters * 0.90;
                }


                System.out.printf("%.2f lv.", priceWithLiters);
                break;
        }
    }
}
