package Exam_Prep;

import java.util.Scanner;

public class Family_Trip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int countNights = Integer.parseInt(scanner.nextLine());
        double pricePerNight = Double.parseDouble(scanner.nextLine());
        int percentage = Integer.parseInt(scanner.nextLine());


        if (countNights > 7) {
            pricePerNight = pricePerNight * 0.95;

        }
        double sumNights = countNights * pricePerNight;
        double additionalExpenses = (percentage / 100.0) * budget;
        double totalSUm = sumNights + additionalExpenses;
        double dif = Math.abs(budget - totalSUm);

        if (budget >= totalSUm){
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", dif);
        }else System.out.printf("%.2f leva needed.", dif);
    }
}
