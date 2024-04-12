package lab;

import java.util.Scanner;

public class Sum_of_Odd_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOddNumbers = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i < numOddNumbers * 2; i++) {
            if (i % 2 != 0) {
                sum = sum + i;
                System.out.println(i);
            }
        }
        System.out.println("Sum: " + sum);
    }
}
