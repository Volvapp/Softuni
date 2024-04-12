package exerciseDataTypesAndVariables;

import java.util.Scanner;

public class waterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tank = 255;
        int n = Integer.parseInt(scanner.nextLine());
        int lines = n;
        int sumOfLiters = 0;
        for (int i = 1; i <= lines; i++) {
            n = Integer.parseInt(scanner.nextLine());

            sumOfLiters += n;
            if (sumOfLiters > tank) {
                System.out.println("Insufficient capacity!");
                sumOfLiters -= n;

            }
        }
        System.out.println(sumOfLiters);
    }
}
