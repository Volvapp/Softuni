package Exam;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//    •	Нощувка - 20 лв.
//•	Карта за транспорт - 1.60 лв.
//•	Билет за музей - 6 лв.


        int people = Integer.parseInt(scanner.nextLine());
        int countNights = Integer.parseInt(scanner.nextLine());
        int transportCards = Integer.parseInt(scanner.nextLine());
        int museumTicketCount = Integer.parseInt(scanner.nextLine());
        int oneNightPrice = 20;
        double transportCard = 1.60;
        int museumTicketPrice =  6;

        double nightsPerPerson = countNights * oneNightPrice;
        double transportCardsPrice = transportCard * transportCards;
        double museumTicketsPricing = museumTicketCount * museumTicketPrice;
        double pricePerPerson = nightsPerPerson + transportCardsPrice + museumTicketsPricing;
        double sumAllPeople = pricePerPerson * people;
        System.out.printf("%.2f", sumAllPeople * 1.25);
    }
}