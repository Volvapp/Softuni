package basicSyntaxExercise;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int orders = Integer.parseInt(scanner.nextLine());
        double pricePerCapsule = Double.parseDouble(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int capsulesCount = Integer.parseInt(scanner.nextLine());
        //((daysInMonth * capsulesCount) * pricePerCapsule)
        double sumPerOrder = 0;
        double sumAll = 0;
        for (int i = 1; i <= orders; i++) {
            if (i > 1) {
                pricePerCapsule = Double.parseDouble(scanner.nextLine());
                days = Integer.parseInt(scanner.nextLine());
                capsulesCount = Integer.parseInt(scanner.nextLine());
            }
            sumPerOrder = pricePerCapsule * capsulesCount * days;
            sumAll += sumPerOrder;
            System.out.printf("The price for the coffee is: $%.2f%n", sumPerOrder);
        }
        System.out.printf("Total: $%.2f", sumAll);
    }
}
