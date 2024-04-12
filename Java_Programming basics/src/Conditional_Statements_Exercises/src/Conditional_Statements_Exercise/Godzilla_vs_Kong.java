package Conditional_Statements_Exercise;

import java.util.Scanner;

public class Godzilla_vs_Kong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Декорът за филма е на стойност 10% от бюджета.
        //При повече от 150 статиста,  има отстъпка за облеклото на стойност 10%

        double movieBudget = Double.parseDouble(scanner.nextLine());
        int statistsCount = Integer.parseInt(scanner.nextLine());
        double singleStatistFitPrice = Double.parseDouble(scanner.nextLine());
        double fitPrice = statistsCount * singleStatistFitPrice;
        if (statistsCount > 150){
            fitPrice = fitPrice - fitPrice * 0.10;
        }

        double decorPrice = movieBudget * 0.10;
        double allSum = fitPrice + decorPrice;
        double leftMoney = movieBudget - allSum;
        double absolute = Math.abs(leftMoney);


        if (leftMoney > 0) {
            System.out.printf("Action!\n" +
                    "Wingard starts filming with %.2f leva left.", absolute);

        }else System.out.printf("Not enough money! \n" +
                "Wingard needs %.2f leva more.", absolute);
    }
}
