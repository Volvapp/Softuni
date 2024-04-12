package Nested_Loops_Exercise;

import java.util.Scanner;

public class Sum_Prime_Non_Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int primeSum = 0;
        int nonPrimeSum = 0;
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int currentNum = Integer.parseInt(input);


            if (currentNum < 0) {
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }
            int counter = 0;
            for (int i = 1; i <= currentNum; i++) {
                if (currentNum % i == 0) {
                    counter++;
                }
            }
            if (counter == 2) {
                primeSum += currentNum;
            } else {
                nonPrimeSum += currentNum;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n Sum of all non prime numbers is: %d", primeSum, nonPrimeSum);
    }
}
