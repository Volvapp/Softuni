import java.util.Scanner;

public class Basketball_Equipment_E8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yearTax = Integer.parseInt(scanner.nextLine());

        double priceShoes = yearTax -(yearTax - 0.40);
        double priceEkip = priceShoes - (priceShoes * 0.20);
        double priceBall = priceEkip / 4;
        double priceAcc = priceBall / 5;

        double totalSum = priceShoes + priceEkip + priceBall + priceAcc + yearTax;

        System.out.println(totalSum);
    }
}
