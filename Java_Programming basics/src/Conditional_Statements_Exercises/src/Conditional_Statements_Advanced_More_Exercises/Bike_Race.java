package Conditional_Statements_Advanced_More_Exercises;

import java.util.Scanner;

public class Bike_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniorParticipants = Integer.parseInt(scanner.nextLine());
        int seniorParticipants = Integer.parseInt(scanner.nextLine());
        String typeRace = scanner.nextLine();
        double juniorPrice = 0;
        double seniorPrice = 0;
        double allParticipants = juniorParticipants + seniorParticipants;
        double priceAllParticipants = 0;
        double crossCountryBullshit = 0;

        switch (typeRace) {
            case "trail":
                juniorPrice = juniorParticipants * 5.50;
                seniorPrice = seniorParticipants * 7;
                priceAllParticipants = (juniorPrice + seniorPrice) * 0.95;
                System.out.printf("%.2f", priceAllParticipants);
                break;

            case "cross-country":
                juniorPrice = juniorParticipants * 8;
                seniorPrice = seniorParticipants * 9.5;
                if (allParticipants >= 50) {
                    priceAllParticipants = (juniorPrice + seniorPrice) * 0.75;
                    priceAllParticipants = priceAllParticipants * 0.95;
                    System.out.printf("%.2f", priceAllParticipants);
                } else {
                    priceAllParticipants = (juniorPrice + seniorPrice) * 0.95;
                    System.out.printf("%.2f", priceAllParticipants);
                    break;
                }break;
            case "downhill":
                juniorPrice = juniorParticipants * 12.25;
                seniorPrice = seniorParticipants * 13.75;
                priceAllParticipants = (juniorPrice + seniorPrice) * 0.95;
                System.out.printf("%.2f", priceAllParticipants);
                break;
            case "road":
                juniorPrice = juniorParticipants * 20;
                seniorPrice =seniorParticipants * 21.50;
                priceAllParticipants = (juniorPrice + seniorPrice) * 0.95;
                System.out.printf("%.2f", priceAllParticipants);
                break;
        }

    }
}
