package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Prime_Pairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumStart = Integer.parseInt(scanner.nextLine());
        int secondNumStart = Integer.parseInt(scanner.nextLine());
        int diffFirstPair = Integer.parseInt(scanner.nextLine());
        int diffSecondPair = Integer.parseInt(scanner.nextLine());

        int limitNum1 = firstNumStart + diffFirstPair;
        int limitNum2 = secondNumStart + diffSecondPair;
        boolean flag = false;

        for (int i = firstNumStart; i <= limitNum1; ++i) {
            for (int j = secondNumStart; j <= limitNum2; ++j) {
                for (int k = 2; k <= i / 2; k++) {
                    for (int l = 2; l <= j / 2; l++) {
                        flag = false;

                        if (i % k == 0 || j % l == 0) {
                            flag = true;
                            break;
                        }
                    }
                    if (i % 2 != 0 && j % 2 != 0 && !flag) {
                        System.out.printf("%d%d%n", i, j);
                        break;
                    }
                    if (diffFirstPair > i || diffSecondPair > j) {
                        return;
                    }
                }
            }
        }
    }
}

