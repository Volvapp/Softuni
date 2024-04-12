package Harder_Conditional_Statements_Exercises;

import java.util.Scanner;

public class Hotel_Room {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        //May, June, July, August, September или October
        int countNights = Integer.parseInt(scanner.nextLine());

        double studio = 0;
        double apartment = 0;

        if (month.equals("May") || month.equals("October")) {
            studio = 50;//per night
            apartment = 65;//per night
            if (countNights > 7 && countNights <= 14) {
                studio = (studio * 0.95) * countNights;
                apartment = apartment * countNights;
            } else if (countNights > 14) {
                studio = (studio * 0.70) * countNights;
                apartment = (apartment * 0.90) * countNights;
            } else {
                studio = studio * countNights;
                apartment = apartment * countNights;
            }
        }
        if (month.equals("June") || month.equals("September")) {
            studio = 75.20; //per night
            apartment = 68.70; //per night

            if (countNights > 7 && countNights <= 14) {
                studio = 75.20 * countNights;
                apartment = 68.70 * countNights;
            } else if (countNights > 14) {
                studio = studio * 0.80 * countNights;
                apartment = apartment * 0.90 * countNights;
            } else {
                studio = studio * countNights;
                apartment = apartment * countNights;
            }
        }
        if (month.equals("July") || month.equals("August")) {
            studio = 76; //per night
            apartment = 77; //per night
            if (countNights > 7 && countNights <= 14) {
                studio = 76 * countNights;
                apartment = 77 * countNights;
            } else if (countNights > 14) {
                studio = 76 * countNights;
                apartment = apartment * 0.90 * countNights;
            } else {
                studio = studio * countNights;
                apartment = apartment * countNights;
            }
        }
        System.out.printf("Apartment: %.2f lv. " +
                "\n Studio: %.2f lv.", apartment, studio);
    }
}
