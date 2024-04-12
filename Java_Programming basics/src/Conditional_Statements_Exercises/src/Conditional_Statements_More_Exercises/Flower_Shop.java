package Conditional_Statements_More_Exercises;

import java.util.Scanner;

public class Flower_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Магнолии – 3.25 лева
        //Зюмбюли – 4 лева
        //Рози – 3.50 лева
        //Кактуси – 8 лева
        //От общата сума, Мария трябва да плати 5% данъци.

        int magnoliasCount = Integer.parseInt(scanner.nextLine());
        int hyacinthsCount = Integer.parseInt(scanner.nextLine());
        int rosesCount = Integer.parseInt(scanner.nextLine());
        int cactiCount = Integer.parseInt(scanner.nextLine());
        double presentPrice = Double.parseDouble(scanner.nextLine());

        double magnoliasPrice = magnoliasCount * 3.25;
        double hyacinthsPrice = hyacinthsCount * 4;
        double rosesPrice = rosesCount * 3.5;
        double cactiPrice = cactiCount * 8;
        double sumWithoutTax = magnoliasPrice + hyacinthsPrice +rosesPrice + cactiPrice;
        double tax = sumWithoutTax * 0.05;
        double sumWithTax = sumWithoutTax - tax;

        if (presentPrice > sumWithTax){
            double neededMoney = Math.ceil(presentPrice - sumWithTax);
            System.out.printf("She will have to borrow %.0f leva.", neededMoney);
        }else {
            double leftMoney = Math.floor(sumWithTax - presentPrice);
            System.out.printf("She is left with %.0f leva.", leftMoney);
        }
    }
}
