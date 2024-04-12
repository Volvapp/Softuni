package dataTypesAndVariablesLab;

import java.util.Scanner;

public class refactorSpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        boolean isSpecialNum = false;

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = 0;
            num = i;
            while (num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            isSpecialNum = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecialNum) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }

    }
}
