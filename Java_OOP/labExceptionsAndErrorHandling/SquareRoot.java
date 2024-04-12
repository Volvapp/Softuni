package labExceptionsAndErrorHandling;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        try {
            int number = Integer.parseInt(input);
            if (number < 0){
                System.out.println("Invalid");
            }
            System.out.printf("%.2f%n", Math.sqrt(number));
        } catch (Exception e) {
            System.out.println("Invalid");
        }

        System.out.println("Goodbye");
    }
}
