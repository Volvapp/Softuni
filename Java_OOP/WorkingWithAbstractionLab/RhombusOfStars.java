package WorkingWithAbstractionLab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= n; i++) {
            printRow(i, n - i);
        }
        for (int i = n - 1; i > 0; i--) {
            printRow(i, n - i);
        }
    }

    private static void printRow(int count, int leadingSpaces) {
        for (int i = 0; i < leadingSpaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < count; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}