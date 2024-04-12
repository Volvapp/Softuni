package AdvancedMidExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listMales = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> listFemales = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(listMales);
        ArrayDeque<Integer> maleQueue = new ArrayDeque<>(listMales);
        ArrayDeque<Integer> femaleStack = new ArrayDeque<>(listFemales);

        int matches = 0;

        while (!maleQueue.isEmpty() && !femaleStack.isEmpty()) {
            int currentMale = maleQueue.poll();
            int currentFemale = femaleStack.pop();


            if (currentMale <= 0){
                femaleStack.push(currentFemale);
                continue;
            }
            if (currentFemale <= 0){
                maleQueue.offerFirst(currentMale);
                continue;
            }

            if (currentMale % 25 == 0) {
                maleQueue.poll();
                femaleStack.push(currentFemale);
                continue;
            }

            if (currentFemale % 25 == 0) {
                femaleStack.pop();
                maleQueue.offerFirst(currentMale);
                continue;
            }

            if (currentMale != currentFemale) {


                maleQueue.offerFirst(currentMale - 2);

            } else {
                matches++;
            }




        }


        System.out.println("Matches: " + matches);
        System.out.print("Males left: ");
        if (maleQueue.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(String.join(", ", String.valueOf(maleQueue).replaceAll("[\\[\\]]", "")));
        }
        System.out.print("Females left: ");
        if (femaleStack.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(String.join(", ", String.valueOf(femaleStack).replaceAll("[\\[\\]]", "")));
        }
    }
}
