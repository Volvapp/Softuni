package lab;

import java.util.Scanner;

public class Theatre_Promotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        int price = 0;
        switch (day) {
            case "Weekday":
                if (age <= 18 && age >= 0) {
                    price = 12;
                    System.out.print(price + "$");
                    break;
                } else if (age > 18 && age <= 64) {
                    price = 18;
                    System.out.print(price + "$");
                    break;
                } else if (age > 64 && age <= 122) {
                    price = 12;
                    System.out.print(price + "$");
                    break;
                } else {
                    System.out.println("Error!");
                    break;
                }
            case "Weekend":
                if (age <= 18 && age >= 0) {
                    price = 15;
                    System.out.print(price + "$");
                    break;
                } else if (age > 18 && age <= 64) {
                    price = 20;
                    System.out.print(price + "$");
                    break;
                } else if (age > 64 && age <= 122) {
                    price = 15;
                    System.out.print(price + "$");
                    break;
                } else {
                    System.out.println("Error!");
                    break;
                }
            case "Holiday":
                if (age <= 18 && age >= 0) {
                    price = 5;
                    System.out.print(price + "$");
                    break;
                } else if (age > 18 && age <= 64) {
                    price = 12;
                    System.out.print(price + "$");
                    break;
                } else if (age > 64 && age <= 122) {
                    price = 10;
                    System.out.print(price + "$");
                    break;
                } else {
                    System.out.println("Error!");
                    break;
                }
        }
    }
}