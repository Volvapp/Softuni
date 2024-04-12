package AdvancedMidExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnergyDrinks {
    public static final int MAXIMUM_CAFFEINE = 300;
    public static final int EXCEED_CAFFEINE = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialCaffeine = 0;

        List<Integer> caffeineList = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> energyDrinksList = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        ArrayDeque<Integer> milsOfCaffeine = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();

        for (int currentMils : caffeineList) {
            milsOfCaffeine.push(currentMils);
        }
        for (int currentDrinks : energyDrinksList) {
            energyDrinks.offer(currentDrinks);
        }

        int stamatsCaffeine = 0;

        while (!energyDrinks.isEmpty() && !milsOfCaffeine.isEmpty()) {

            int currentDrink = energyDrinks.poll();
            int currentMils = milsOfCaffeine.pop();

            int sum = currentDrink * currentMils;

            if (sum + stamatsCaffeine <= MAXIMUM_CAFFEINE) {
                stamatsCaffeine += sum;
            } else {
                energyDrinks.offer(currentDrink);
                if (stamatsCaffeine >= EXCEED_CAFFEINE) {
                    stamatsCaffeine -= EXCEED_CAFFEINE;
                }
            }
        }
        if (!energyDrinks.isEmpty()){
            System.out.print("Drinks left: ");
            String format = energyDrinks.toString();
            System.out.println(format.replaceAll("[\\[\\]]", ""));
        }else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.println("Stamat is going to sleep with " + stamatsCaffeine + " mg caffeine.");
    }
}
