package labExceptionsAndErrorHandling;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] range = scanner.nextLine().split("\\s+");
        int startingNumber = Integer.parseInt(range[0]);
        int endNumber = Integer.parseInt(range[1]);


        System.out.printf("Range: [%d...%d]%n", startingNumber, endNumber);

        int validNum = readNumber(scanner, startingNumber, endNumber);
        System.out.printf("Valid number: %d", validNum);
    }

    private static int readNumber(Scanner scanner, int startingNum, int endNumber) {
        for (; ; ) {
            String input = scanner.nextLine();

            try {
                int number = Integer.parseInt(input);
                if (number <= endNumber && number >= startingNum) {
                    return number;
                }
            } catch (Exception e) {
            }
            System.out.printf("Invalid number: %s%n", input);
        }
    }
}
