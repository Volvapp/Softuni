package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Sum_of_Two_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int intervalStart = Integer.parseInt(scanner.nextLine());
        int intervalEnd = Integer.parseInt(scanner.nextLine()); // [по-голямо от първото число...1000]
        int wantedNum = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (int i = intervalStart; i <= intervalEnd ; i++) {
            for (int j = intervalStart; j <= intervalEnd; j++) {
                counter++;
                if (i + j == wantedNum) {

                    System.out.printf("Combination N:%d (%d + %d = %d)", counter, i, j, wantedNum);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", counter, wantedNum);
    }
}
