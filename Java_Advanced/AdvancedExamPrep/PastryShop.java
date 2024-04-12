package AdvancedExamPrep;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PastryShop {

    private static final int BISCUIT_VALUE = 25;
    private static final int CAKE_VALUE = 50;
    private static final int PASTRY = 75;
    private static final int PIE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+"); // liquids
        String[] secondLine = scanner.nextLine().split("\\s+"); // ingredients

        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        for (String liquidInfo : firstLine) {
            liquids.offer(Integer.parseInt(liquidInfo));
        }

        for (String ingredientInfo : secondLine) {
            ingredients.push(Integer.parseInt(ingredientInfo));
        }

        int biscuitCount = 0, cakeCount = 0, pastryCount = 0, pieCount = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int possibleDish = liquid + ingredient;

            switch (possibleDish) {
                case BISCUIT_VALUE:
                    biscuitCount++;
                    break;

                case CAKE_VALUE:
                    cakeCount++;
                    break;

                case PASTRY:
                    pastryCount++;
                    break;

                case PIE:
                    pieCount++;
                    break;

                default:
                    ingredients.push(ingredient + 3);
                    break;
            }
        }

        if (biscuitCount > 0 && cakeCount > 0 && pastryCount > 0 && pieCount > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(liquids.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(ingredients.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.printf("Biscuit: %d%n" +
                "Cake: %d%n" +
                "Pie: %d%n" +
                "Pastry: %d%n", biscuitCount, cakeCount, pieCount, pastryCount);
    }
}
