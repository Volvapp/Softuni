package Conditional_Statements_Exercise;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int graphicsCardPriceOne = 250;

        double budget = Double.parseDouble(scanner.nextLine());
        int graphicsCardCount = Integer.parseInt(scanner.nextLine());
        int processorsCount = Integer.parseInt(scanner.nextLine());
        int ramCount = Integer.parseInt(scanner.nextLine());

        double graphicsCardPriceAll = graphicsCardPriceOne * graphicsCardCount;
        double processorPriceOne = graphicsCardPriceAll * 0.35;
        double processorPriceALl = processorPriceOne * processorsCount;
        double ramPriceOne = graphicsCardPriceAll * 0.10;
        double ramPriceAll = ramPriceOne * ramCount;

        double sumAll = ramPriceAll + processorPriceALl + graphicsCardPriceAll;
        double diff = budget - sumAll;
        double absolute = Math.abs(diff);

        if (graphicsCardCount > processorsCount){
            sumAll = sumAll - sumAll * 0.15;
            diff = budget - sumAll;
            absolute = Math.abs(diff);

        } if (diff >= 0){
            System.out.printf("You have %.2f leva left!", absolute);

        }else System.out.printf("Not enough money! You need %.2f leva more!", absolute);

        }

    }

