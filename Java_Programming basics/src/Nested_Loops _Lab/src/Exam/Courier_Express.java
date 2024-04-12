package Exam;

import java.util.Scanner;

public class Courier_Express {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double deliveryKg = Double.parseDouble(scanner.nextLine());
        String typeDelivery = scanner.nextLine();
        int distanceKm = Integer.parseInt(scanner.nextLine());
        double priceForKm = 0;
        double overPricingKg = 0;
        double overPricingKm = 0;
        double priceKmAll = 0;

        if (typeDelivery.equals("standard")) {
            if (deliveryKg < 1) {
                priceForKm = distanceKm * 3;// Стотинки
            } else if (deliveryKg < 10) {
                priceForKm = distanceKm * 5;
            } else if (deliveryKg <= 40) {
                priceForKm = distanceKm * 10;
            } else if (deliveryKg <= 90) {
                priceForKm = distanceKm * 15;
            } else if (deliveryKg <= 150) {
                priceForKm = distanceKm * 20;
            }
            System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.", deliveryKg, priceForKm / 100);
        }
        if (typeDelivery.equals("express")) {
            if (deliveryKg < 1) {
                priceForKm = distanceKm * 3;
                overPricingKg = 0.80 * 3;
                overPricingKm = deliveryKg * overPricingKg * distanceKm;
                priceKmAll = priceForKm + overPricingKm;// Стотинки

            } else if (deliveryKg < 10) {
                priceForKm = distanceKm * 5;
                overPricingKg = 0.40 * 5;
                overPricingKm = deliveryKg * overPricingKg * distanceKm;
                priceKmAll = priceForKm + overPricingKm;
            } else if (deliveryKg <= 40) {
                priceForKm = distanceKm * 10;
                overPricingKg = 0.05 * 10;
                overPricingKm = deliveryKg * overPricingKg * distanceKm;
                priceKmAll = priceForKm + overPricingKm;
            } else if (deliveryKg <= 90) {
                priceForKm = distanceKm * 15;
               overPricingKg = 0.02 * 15;
               overPricingKm = deliveryKg * overPricingKg * distanceKm;
               priceKmAll = priceForKm + overPricingKm;
            } else if (deliveryKg <= 150) {
                priceForKm = distanceKm * 20;
                overPricingKg = 0.01 * 20;
                overPricingKm = deliveryKg * overPricingKg * distanceKm;
                priceKmAll = priceForKm + overPricingKm;
            }
            System.out.printf("The delivery of your shipment with weight of %.3f kg. would cost %.2f lv.", deliveryKg, priceKmAll / 100);
        }
    }
}