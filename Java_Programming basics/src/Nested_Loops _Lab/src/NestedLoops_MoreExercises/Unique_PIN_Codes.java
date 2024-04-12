package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Unique_PIN_Codes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i <= firstNum; i++) {

            for (int j = 2; j <= secondNum; j++) {
                for (int k = 2; k <= thirdNum; k++) {
                    if (i % 2 == 0 && j != 4 && j != 6 && j != 8 && j != 9 && k % 2 == 0){
                        System.out.printf("%d %d %d%n", i, j, k);
                    }
                    }
                }
            }
        }
    }
