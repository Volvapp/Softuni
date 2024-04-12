package Harder_Conditional_Statements;

import java.util.Scanner;

public class Fruit_Shop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fruit = scanner.nextLine();
        String weekDay = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        //(banana / apple / orange / grapefruit / kiwi / pineapple / grapes),
        // ден от седмицата (Monday / Tuesday / Wednesday / Thursday / Friday / Saturday / Sunday)
        double price;
        price = 0.0;
        if (weekDay.equals("Monday") || weekDay.equals("Tuesday") || weekDay.equals("Wednesday") || weekDay.equals("Thursday") || weekDay.equals("Friday")) {
            if (fruit.equals("banana")) {
                price = quantity * 2.50;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("apple")) {
                price = quantity * 1.20;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("orange")) {
                price = quantity * 0.85;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("grapefruit")) {
                price = quantity * 1.45;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("kiwi")) {
                price = quantity * 2.70;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("pineapple")) {
                price = quantity * 5.50;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("grapes")) {
                price = quantity * 3.85;
                System.out.printf("%.2f", price);
            } else System.out.println("error");
        } else if (weekDay.equals("Saturday") || weekDay.equals("Sunday")) {
            if (fruit.equals("banana")) {
                price = quantity * 2.70;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("apple")) {
                price = quantity * 1.25;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("orange")) {
                price = quantity * 0.90;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("grapefruit")) {
                price = quantity * 1.60;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("kiwi")) {
                price = quantity * 3.00;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("pineapple")) {
                price = quantity * 5.60;
                System.out.printf("%.2f", price);
            } else if (fruit.equals("grapes")) {
                price = quantity * 4.20;
                System.out.printf("%.2f", price);
            } else {
                System.out.println("error");
            }

        }else {
            System.out.println("error");
        }
    }

}

//плод	banana	apple	orange	grapefruit	kiwi	pineapple	grapes
//цена	2.50	1.20	0.85	1.45	2.70	5.50	3.85
//Събота и неделя магазинът работи на по-високи цени:
//плод	banana	apple	orange	grapefruit	kiwi	pineapple	grapes
//цена	2.70	1.25	0.90	1.60	3.00	5.60	4.20