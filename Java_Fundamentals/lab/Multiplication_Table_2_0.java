package lab;

import java.util.Scanner;

public class Multiplication_Table_2_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int multiplier = Integer.parseInt(scanner.nextLine());
        int command = multiplier;

        do {
            System.out.printf("%d X %d = %d%n", n, multiplier, n * multiplier);
            command++;
            multiplier++;
            }while (command <= 10);

    }
}

