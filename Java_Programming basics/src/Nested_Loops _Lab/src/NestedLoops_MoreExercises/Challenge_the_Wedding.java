package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Challenge_the_Wedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int men = Integer.parseInt(scanner.nextLine());
        int women = Integer.parseInt(scanner.nextLine());
        int maximumTables = Integer.parseInt(scanner.nextLine()); // по 2ма души на маса
        int tableCounter = 0;
        for (int i = 1; i <= men; i++) {
            for (int j = 1; j <= women; j++) {

                if (i <= men && j <= women) {
                    tableCounter++;
                }
                if (tableCounter > maximumTables) {
                    break;
                }
                System.out.printf("(%d <-> %d) ", i, j);
            }
        }
    }
}