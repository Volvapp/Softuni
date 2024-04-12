package Conditional_Statements_Exercise;

import java.util.Scanner;

public class Toy_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzlesCount = Integer.parseInt(scanner.nextLine());
        int dollsCount = Integer.parseInt(scanner.nextLine());
        int bearsCount = Integer.parseInt(scanner.nextLine());
        int minionsCount = Integer.parseInt(scanner.nextLine());
        int trucksCount = Integer.parseInt(scanner.nextLine());

        double allSum = (puzzlesCount * 2.60) +
                (dollsCount * 3.0) +
                (bearsCount * 4.10) +
                (minionsCount * 8.20) +
                (trucksCount * 2.0);

        int countAllToys = puzzlesCount + dollsCount + bearsCount + minionsCount + trucksCount;

        if (countAllToys >= 50){
            allSum = allSum - (allSum * 0.25);
            //allSum = allSum * 0.75;
        }
        allSum = allSum - (allSum * 0.10);

        double diff = Math.abs(allSum - tripPrice);

        if (allSum >= tripPrice) {
            System.out.printf("Yes! %.2f lv left.", diff);

        }else {
            System.out.printf("Not enough money! %.2f lv needed.", diff);

        }
        }

    }

