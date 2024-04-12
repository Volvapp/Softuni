package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start1 = Integer.parseInt(scan.nextLine());
        int start2 = Integer.parseInt(scan.nextLine());
        int diff1 = Integer.parseInt(scan.nextLine());
        int diff2 = Integer.parseInt(scan.nextLine());

        int end1 = start1 + diff1;
        int end2 = start2 + diff2;

        for (int i = start1; i <= end1; i++) {
            for (int j = start2; j <= end2; j++) {
                String result = "";
                for (int k = 2; k < i; k++) {
                    if (i % k == 0) {
                        result = "";
                        break;
                    } else if (k == i - 1) {
                        result += i;
                    }
                }
                if (!result.isEmpty()) {
                    for (int k = 2; k < j; k++) {
                        if (j % k == 0) {
                            result = "";
                            break;
                        } else if (k == j - 1) {
                            result += j;
                        }
                    }
                }
                if (!result.isEmpty()) {
                    System.out.printf("%d%d%n", i, j);
                }
            }
        }
    }
}

