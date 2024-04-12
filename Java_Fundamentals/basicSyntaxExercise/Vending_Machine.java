package basicSyntaxExercise;

import java.util.Scanner;

public class Vending_Machine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//Your vending machine only works with 0.1, 0.2, 0.5, 1, and 2 coins.
        //Nuts", "Water", "Crisps", "Soda", "Coke".
        // 2.0,     0.7,    1.5,    0.8,    1.0
        String command = scanner.nextLine();
        double insertedCoins = 0;
        double priceOfThing;
        double change = 0;
        String product = "";
        while (!command.equals("End")) {
            while (!command.equals("Start")) {
                if (command.equals(product)) {
                    break;
                }
                double coins = Double.parseDouble(command);
                if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {

                    insertedCoins += coins;
                    change = insertedCoins;
                } else {
                    System.out.printf("Cannot accept %.2f%n", coins);
                }
                command = scanner.nextLine();
            }
            command = scanner.nextLine();
            if (command.equals("End")) {
                break;
            }product = command;

            switch (command) {
                case "Nuts":
                    priceOfThing = 2.0;

                    if (priceOfThing <= insertedCoins) {
                        change -= priceOfThing;
                        System.out.printf("Purchased %s%n", command);
                    } else System.out.println("Sorry, not enough money");
                    break;
                case "Water":
                    priceOfThing = 0.7;

                    if (priceOfThing <= change) {
                        change -= priceOfThing;
                        System.out.printf("Purchased %s%n", command);
                    } else System.out.println("Sorry, not enough money");
                    break;
                case "Crisps":
                    priceOfThing = 1.5;

                    if (priceOfThing <= change) {
                        change -= priceOfThing;
                        System.out.printf("Purchased %s%n", command);
                    } else System.out.println("Sorry, not enough money");
                    break;
                case "Soda":
                    priceOfThing = 0.8;

                    if (priceOfThing <= change) {
                        change -= priceOfThing;
                        System.out.printf("Purchased %s%n", command);
                    } else System.out.println("Sorry, not enough money");
                    break;
                case "Coke":
                    priceOfThing = 1.0;

                    if (priceOfThing <= change) {
                        change -= priceOfThing;
                        System.out.printf("Purchased %s%n", command);
                    } else System.out.println("Sorry, not enough money");
                    break;
                default:
                    System.out.println("Invalid product");
            }
        }
        System.out.printf("Change: %.2f", change);
    }
}

