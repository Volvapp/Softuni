package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Password_Generator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        secondNum = secondNum + 97;
        char k = 0;
        char l = 0;

        for (int i = 1; i < firstNum; i++) {
            for (int j = 1; j < firstNum; j++) {
                for (k = 97; k < secondNum; k++) {
                    for (l = 97; l < secondNum; l++) {
                        for (int m = 1; m <= firstNum; m++) {

                            if (m > i && m > j) {
                                System.out.printf("%d%d%c%c%d ", i, j, k, l, m);
                            }
                        }
                    }
                }
            }
        }
    }
}
