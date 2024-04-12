package While_Loop_More_Exercises;

import java.util.Scanner;

public class Dish {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Знае се, че всяка бутилка съдържа 750 мл. препарат,
        //за 1 чиния са нужни 5 мл.,
        //а за тенджера 15 мл.

        int singleBottleDetergent = 750;
        int countBottleDetergent = Integer.parseInt(scanner.nextLine());
        int detergentMl = singleBottleDetergent * countBottleDetergent;
        int plateCounter = 0;
        int potCounter = 0;
        int chargeCounter = 0;
        int plateDetergent = 0;
        int potDetergent = 0;

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            int countDishes = Integer.parseInt(command);

            chargeCounter++;

            if (chargeCounter % 3 == 0) {
                potDetergent = 15 * countDishes;
                detergentMl = detergentMl - potDetergent;
                potCounter = potCounter + countDishes;
            } else {
                plateDetergent = 5 * countDishes;
                detergentMl = detergentMl - plateDetergent;
                plateCounter = plateCounter + countDishes;
            }
            if (detergentMl < 0) {
                break;
            }command = scanner.nextLine();
        }
        if (detergentMl <= 0) {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(detergentMl));
        } else {
            System.out.printf("Detergent was enough! %d dishes and %d pots were washed." +
                    " Leftover detergent %d ml.", plateCounter, potCounter, detergentMl);
        }
    }
}

