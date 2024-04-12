package dataTypesAndVariablesLab;

import java.util.Scanner;

public class charToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        char third = scanner.nextLine().charAt(0);

        String result = String.format("%s%s%s", first, second, third);
        System.out.println(result);
    }
}
