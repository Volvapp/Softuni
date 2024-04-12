package Exam_Prep;

import java.util.Scanner;

public class Film_Destination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int countDays = Integer.parseInt(scanner.nextLine());
        double pricePerDay = 0;

        if (season.equals("Summer")) {
            if (destination.equals("Dubai")) {
                pricePerDay = 40000;
            } else if (destination.equals("Sofia")) {
                pricePerDay = 12500;
            } else if (destination.equals("London")) {
                pricePerDay = 20250;
            }
        } else if (season.equals("Winter")) {
            if (destination.equals("Dubai")) {
                pricePerDay = 45000;
            } else if (destination.equals("Sofia")) {
                pricePerDay = 17000;
            } else if (destination.equals("London")) {
                pricePerDay = 24000;
            }

        }double priceAll = pricePerDay * countDays;

        if (destination.equals("Dubai")){
            priceAll = priceAll * 0.70;
        }else if (destination.equals("Sofia")){
            priceAll = priceAll * 1.25;
        }double dif = Math.abs(budget - priceAll);
        if (budget >= priceAll){
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", dif);
        }else {
            System.out.printf("The director needs %.2f leva more!", dif);
        }
    }
}
