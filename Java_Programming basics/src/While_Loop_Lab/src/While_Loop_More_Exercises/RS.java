package While_Loop_More_Exercises;

import java.util.Scanner;

public class RS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	Ако продуктът надвишава 100лв., за него не може да се плати в брой
        //•	Ако продуктът е на цена под 10лв., за него не може да се плати с кредитна карта
        int expectedSum = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int cardCounter = 0;
        int cashCounter = 0;
        double sumOfAllThings = 0;
        int typeOfPayment = 0;
        double cardPayment = 0;
        double cashPayment = 0;
        double cashAverage = 0;
        double cardAverage = 0;

        while (!command.equals("End")) {

            int priceOfThings = Integer.parseInt(command);

            typeOfPayment++;

            if (typeOfPayment % 2 == 0 && priceOfThings >= 10) {
                cardCounter++;
                cardPayment = cardPayment + priceOfThings;
                System.out.println("Product sold!");
            } else if (typeOfPayment % 2 != 0 && priceOfThings <= 100) {
                cashCounter++;
                cashPayment = cashPayment + priceOfThings;
                System.out.println("Product sold!");
            } else {
                System.out.println("Error in transaction!");
            }
            sumOfAllThings = cashPayment + cardPayment;
            if (expectedSum <= sumOfAllThings) {
                break;
            }
            command = scanner.nextLine();

        }
        cashAverage = cashPayment / cashCounter;
        cardAverage = cardPayment / cardCounter;
        if (expectedSum > sumOfAllThings) {
            System.out.println("Failed to collect required money for charity.");
        } else {
            System.out.printf("Average CS: %.2f %n Average CC: %.2f", cashAverage, cardAverage);
        }

    }
}

