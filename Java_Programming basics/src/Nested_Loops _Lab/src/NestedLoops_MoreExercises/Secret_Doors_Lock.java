package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Secret_Doors_Lock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hundreds = Integer.parseInt(scanner.nextLine());
        int tens = Integer.parseInt(scanner.nextLine());
        int units = Integer.parseInt(scanner.nextLine());

        boolean primeNumCheck;
        for (int i = 1; i <= 9; i++) { // hundreds
            for (int j = 2; j <= 7; j++) { // tens
                for (int k = 1; k <= 9; k++) { //units
                    primeNumCheck = j == 2 || j == 3 || j == 5 || j == 7;
                    if (i > hundreds || tens < j || units < k) {
                        break;
                    }
                    if (i % 2 == 0 && k % 2 == 0 && primeNumCheck) {
                        System.out.printf("%d %d %d%n ", i, j, k);
                    }
                }
            }
        }
    }
}
