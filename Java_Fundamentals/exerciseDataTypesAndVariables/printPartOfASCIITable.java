package exerciseDataTypesAndVariables;

import java.util.Scanner;

public class printPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());

        for (char i = (char) start; i <= end; i++) {
            System.out.print(i + " ");
        }
    }
}
