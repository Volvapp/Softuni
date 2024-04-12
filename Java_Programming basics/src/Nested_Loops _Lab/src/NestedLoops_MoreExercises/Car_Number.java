package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Car_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int lastNum = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    for (int l = 1; l <= 9; l++) {
                        if (i > l && (j + k) % 2 == 0) {
                            if (i >= firstNum && i <= lastNum) {
                                if (j >= firstNum && j <= lastNum) {
                                    if (k >= firstNum && k <= lastNum) {
                                        if (l >= firstNum) {
                                            if (i % 2 != 0 && l % 2 == 0) {
                                                System.out.printf("%d%d%d%d ", i, j, k, l);
                                            }else if (l % 2 != 0 && i % 2 == 0){
                                                System.out.printf("%d%d%d%d ", i , j, k, l);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

