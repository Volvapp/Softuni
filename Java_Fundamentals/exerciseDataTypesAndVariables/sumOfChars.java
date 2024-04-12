package exerciseDataTypesAndVariables;

import java.util.Scanner;

public class sumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte lines = Byte.parseByte(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= lines; i++) {
            char letters = scanner.nextLine().charAt(0);
            sum += letters;
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
