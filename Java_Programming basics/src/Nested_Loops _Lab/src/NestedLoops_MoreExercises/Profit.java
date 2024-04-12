package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count1Lv = Integer.parseInt(scanner.nextLine()); // монети
        int count2Lv = Integer.parseInt(scanner.nextLine()); // монети
        int count5Lv = Integer.parseInt(scanner.nextLine()); //банкноти
        int wantedNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= count1Lv; i++) {

            for (int j = 0; j <= count2Lv; j++) {

                for (int k = 0; k <= count5Lv; k++) {

                    if ((i*1) + (j*2) + (k*5) == wantedNumber) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", i, j, k, wantedNumber);
                    }
                }
            }
        }
    }
}