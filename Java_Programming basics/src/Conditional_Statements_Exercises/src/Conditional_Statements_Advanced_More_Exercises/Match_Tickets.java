package Conditional_Statements_Advanced_More_Exercises;

import java.util.Scanner;

public class Match_Tickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double VIPTickets = 499.99;
        double normalTickets = 249.99;

        //•	От 5 до 9 – 60% от бюджета.
        //•	От 10 до 24 – 50% от бюджета.
        //•	От 25 до 49 – 40% от бюджета.
        //•	50 или повече – 25% от бюджета.

        double budget = Double.parseDouble(scanner.nextLine());
        String ticketType = scanner.nextLine();
        int peopleCount = Integer.parseInt(scanner.nextLine());
        double transportPrice = 0;
        double leftMoney = 0;
        double priceForEverything = 0;


        if (peopleCount < 5) {
            transportPrice = budget * 0.75;
            leftMoney = budget - transportPrice;
        } else if (peopleCount <= 9) {
            transportPrice = budget * 0.60;
            leftMoney = budget - transportPrice;
        } else if (peopleCount <= 24) {
            transportPrice = budget * 0.50;
            leftMoney = budget - transportPrice;
        } else if (peopleCount <= 49) {
            transportPrice = budget * 0.40;
            leftMoney = budget - transportPrice;
        } else {
            transportPrice = budget * 0.25;
            leftMoney = budget - transportPrice;
        }
        switch (ticketType) {
            case "Normal":
                priceForEverything = Math.abs(normalTickets * peopleCount + transportPrice);
                leftMoney = Math.abs(budget - priceForEverything);
                break;
            case "VIP":
                priceForEverything = Math.abs(VIPTickets * peopleCount + transportPrice);
                leftMoney = Math.abs(budget - priceForEverything);
                break;
        }
        if (budget > priceForEverything) {
            System.out.printf("Yes! You have %.2f leva left.", leftMoney);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", leftMoney);
        }

    }
}
