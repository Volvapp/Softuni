package While_Loop_More_Exercises;

import java.util.Scanner;

public class Report_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int expectedSumFromSells = Integer.parseInt(scanner.nextLine());
        int typeOfPayment = 0;
        double cardPayment = 0;
        double cashPayment = 0;
        int cardCounter = 0;
        int cashCounter = 0;
        double collectedMoney = 0;
        double cardAverage = 0;
        double cashAverage = 0;

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            int priceOfThings = Integer.parseInt(command);

            typeOfPayment++;


            if (typeOfPayment % 2 == 0 && priceOfThings >= 10) {
                cardPayment = cardPayment + priceOfThings;
                cardCounter++;
                System.out.println("Product sold!");
            } else if (priceOfThings <= 100 && typeOfPayment % 2 != 0) {
                cashPayment = cashPayment + priceOfThings;
                cashCounter++;
                System.out.println("Product sold!");
            } else {
                System.out.println("Error in transaction!");
            }
            collectedMoney = cardPayment + cashPayment;

            if (collectedMoney >= expectedSumFromSells) {
                break;
            }

            command = scanner.nextLine();

        }

        if (collectedMoney < expectedSumFromSells) {
            System.out.println("Failed to collect required money for charity.");
        } else {
            cardAverage = cardPayment / cardCounter;
            cashAverage = cashPayment / cashCounter;
            System.out.printf("Average CS: %.2f %n Average CC: %.2f", cashAverage, cardAverage);
        }
    }
}