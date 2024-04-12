package exerciseDataTypesAndVariables;

import java.util.Scanner;

public class elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double people = Integer.parseInt(scanner.nextLine());
        double capacity = Integer.parseInt(scanner.nextLine());
        double result = Math.ceil(people / capacity);
        System.out.printf("%.0f", result);

    }
}
