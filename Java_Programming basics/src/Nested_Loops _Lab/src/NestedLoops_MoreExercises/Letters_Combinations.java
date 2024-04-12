package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Letters_Combinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String letterOne = scanner.nextLine();
        String letterTwo = scanner.nextLine();
        String letterThree = scanner.nextLine();
        char first = letterOne.charAt(0);
        char last = letterTwo.charAt(0);
        char missed = letterThree.charAt(0);
        int combinationCount = 0;
        String combination = "";

        for (char i = first; i <= last; i++) {
            for (char j = first; j <= last; j++) {
                for (char k = first; k <= last; k++) {
                    if (i != missed && j != missed && k != missed) {
                        System.out.print("" + i + j + k + " ");
                        combinationCount++;
                    }
                }
            }

        }
        System.out.printf("%d ", combinationCount);

    }
}
