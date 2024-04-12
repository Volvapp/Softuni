package AdvancedMidExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    public static final int DATURA_BOMBS = 40;
    public static final int CHERRY_BOMBS = 60;
    public static final int SMOKE_DECOY_BOMBS = 120;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> bombEffectList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> bombCasingList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> effect = new ArrayDeque<>();
        ArrayDeque<Integer> casing = new ArrayDeque<>();

        for (int effectNum : bombEffectList) {
            effect.offer(effectNum);
        }
        for (int casingNum : bombCasingList) {
            casing.push(casingNum);
        }

        int daturaCounter = 0;
        int cherryCounter = 0;
        int smokeCounter = 0;

        boolean isFilled = false;

        while (!effect.isEmpty() && !casing.isEmpty()) {

            int currentEffect = effect.poll();
            int currentCasing = casing.pop();

            int sum = currentCasing + currentEffect;

            switch (sum) {

                case DATURA_BOMBS:
                    daturaCounter++;
                    break;
                case CHERRY_BOMBS:
                    cherryCounter++;
                    break;
                case SMOKE_DECOY_BOMBS:
                    smokeCounter++;
                    break;
                default:
                    casing.push(currentCasing - 5);
                    effect.push(currentEffect);
            }
            if (daturaCounter >= 3 && cherryCounter >= 3 && smokeCounter >= 3) {
                isFilled = true;
                break;
            }
        }
        if (isFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        System.out.print("Bomb Effects: ");
        if (effect.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(String.join(", ", effect.toString().replaceAll("[\\[\\]]", "")));
        }
        System.out.print("Bomb Casings: ");
        if (casing.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(String.join(", ", casing.toString().replaceAll("[\\[\\]]", "")));
        }
        System.out.printf("Cherry Bombs: %d%n" +
                "Datura Bombs: %d%n" +
                "Smoke Decoy Bombs: %d%n", cherryCounter, daturaCounter, smokeCounter);
    }
}
