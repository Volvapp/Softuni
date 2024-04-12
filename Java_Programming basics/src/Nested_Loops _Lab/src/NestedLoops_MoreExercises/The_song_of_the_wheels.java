package NestedLoops_MoreExercises;

import java.util.Scanner;

public class The_song_of_the_wheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int controlNum = Integer.parseInt(scanner.nextLine());
        int counter4 = 0;
        int pA = 0;
        int pB = 0;
        int pC = 0;
        int pD = 0;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {

                        if (a * b + c * d == controlNum && a < b && c > d) {
                            System.out.printf("%d%d%d%d ", a, b, c, d);
                            counter4++;
                        }
                        if (counter4 == 4) {
                            pA = a;
                            pB = b;
                            pC = c;
                            pD = d;
                            counter4++;
                        }
                    }
                }
            }
        }
        if (pA != 0) {
            System.out.printf("%nPassword: %d%d%d%d", pA, pB, pC, pD);
        } else System.out.printf("%nNo!");
    }
}
