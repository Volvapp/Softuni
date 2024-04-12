package Exam;

import java.util.Scanner;

public class Deer_of_Santa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysGone = Integer.parseInt(scanner.nextLine());
        int leftFoodKg = Integer.parseInt(scanner.nextLine());
        double firstDeerFoodKg = Double.parseDouble(scanner.nextLine());
        double secondDeerFoodKg = Double.parseDouble(scanner.nextLine());
        double thirdDeerFoodKg = Double.parseDouble(scanner.nextLine());

        double neededFoodFirst = daysGone * firstDeerFoodKg;
        double neededFoodSecond = daysGone * secondDeerFoodKg;
        double neededFoodThird = daysGone * thirdDeerFoodKg;

        double sumNeededFood = neededFoodFirst + neededFoodSecond + neededFoodThird;

        if (leftFoodKg >= sumNeededFood){
            double diff = Math.floor(leftFoodKg - sumNeededFood);
            System.out.printf("%.0f kilos of food left.", diff);
        }else {
            double diff = (Math.ceil(sumNeededFood - leftFoodKg));
            System.out.printf("%.0f more kilos of food are needed.", diff);
        }
    }
}
