package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Safe_Passwords_Generator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int possiblePasswords = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        char A = 35;
        char B = 64;
        for (int x = 1; x <= a; x++) {
            for (int y = 1; y <= b; y++) {
                if (A > 55){
                    A = 35;
                }if (B > 96){
                    B = 64;
                }

                if (counter == possiblePasswords) {
                    return;
                }counter++;
                System.out.printf("%c%c%d%d%c%c|", A, B, x, y, B, A);
                A++;
                B++;
            }
        }
    }
}