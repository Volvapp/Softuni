package methodsLab;

import java.util.Scanner;

public class orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f", productAndQuantity(product, quantity));
    }

    public static double productAndQuantity(String product, int quantity) {
        double productPrice = 0;
        switch (product) {
            case "water":
                productPrice = 1.0;
                break;
            case "coffee":
                productPrice = 1.5;
                break;
            case "coke":
                productPrice = 1.4;
                break;
            case "snacks":
                productPrice = 2.0;
                break;

        }
        return productPrice * quantity;
    }
}
