package While_Loop_More_Exercises;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Знае се, че всяка бутилка съдържа 750 мл. препарат
        //за 1 чиния са нужни 5 мл.
        //а за тенджера 15 мл.

        int bottleDetergent = 750;
        int countBottlesDetergent = Integer.parseInt(scanner.nextLine());
        int detergentMl = countBottlesDetergent * bottleDetergent;
        int chargeCounter = 0;
        int platesDetergent = 0;
        int potDetergent = 0;
        int potCounter = 0;
        int platesCounter = 0;

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            int countDishes = Integer.parseInt(command);

            chargeCounter++;

            if (chargeCounter % 3 == 0) {
                potDetergent = 15 * countDishes;
                detergentMl = detergentMl - potDetergent;
                potCounter = potCounter + countDishes;
            } else {
                platesDetergent = 5 * countDishes;
                detergentMl = detergentMl - platesDetergent;
                platesCounter = platesCounter + countDishes;
            }
            if (detergentMl < 0) {
                break;
            }
            command = scanner.nextLine();
        }
        if (detergentMl >= 0) {
            System.out.printf("Detergent was enough!%n%d dishes and %d pots were washed.%nLeftover detergent %d ml.", platesCounter, potCounter, detergentMl);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(detergentMl));
        }
    }
}
