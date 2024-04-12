package Conditional_Statements_More_Exercises;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int foodInKg = Integer.parseInt(scanner.nextLine());
        double dogFoodPerDayKg = Double.parseDouble(scanner.nextLine());
        double catFoodPerDayKg = Double.parseDouble(scanner.nextLine());
        double turtleFoodPerDayGr = Double.parseDouble(scanner.nextLine());

        double dogFoodNeeded = dogFoodPerDayKg * days;
        double catFoodNeeded = catFoodPerDayKg * days;
        double turtleFoodNeeded = turtleFoodPerDayGr * days / 1000;
        double sum = dogFoodNeeded + catFoodNeeded + turtleFoodNeeded;

        if (foodInKg >= sum){
           double foodLeft = Math.floor(foodInKg - sum);
            System.out.printf("%.0f kilos of food left.", foodLeft);
        }else {
            double foodLeft = Math.ceil(sum - foodInKg);
            System.out.printf("%.0f more kilos of food are needed.", foodLeft);
        }
    }
}
