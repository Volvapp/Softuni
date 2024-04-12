package lab;

import java.util.Scanner;

public class Multiplication_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int command =1;
        int result = 0;
        while (command <= 10) {
            result = num * command;
            System.out.printf("%d X %d = %d%n",num, command, result);
            command++;

        }
    }
}
