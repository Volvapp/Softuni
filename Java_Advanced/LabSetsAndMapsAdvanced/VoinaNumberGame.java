package LabSetsAndMapsAdvanced;

import java.util.*;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> deckOne = new LinkedHashSet<>();
        Set<Integer> deckTwo = new LinkedHashSet<>();

        String[] inputOne = scanner.nextLine().split("\\s+");

        for (int i = 0; i < inputOne.length; i++) {
            int current = Integer.parseInt(inputOne[i]);
            deckOne.add(current);
        }
        String[] inputTwo = scanner.nextLine().split("\\s+");
        for (int i = 0; i < inputTwo.length; i++) {
            int current = Integer.parseInt(inputTwo[i]);
            deckTwo.add(current);
        }

        for (int steps = 1; steps <= 50; steps++) {

            Integer fighterOne = deckOne.iterator().next();
            Integer fighterTwo = deckTwo.iterator().next();

            deckOne.remove(fighterOne);
            deckTwo.remove(fighterTwo);

            if (fighterOne > fighterTwo) {
                deckOne.add(fighterOne);
                deckOne.add(fighterTwo);
            } else if (fighterOne < fighterTwo){
                deckTwo.add(fighterOne);
                deckTwo.add(fighterTwo);
            }

        }
        if (deckOne.size() > deckTwo.size()) {
            System.out.println("First player win!");

        } else if (deckTwo.size() > deckOne.size()) {

            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }
    }
}
