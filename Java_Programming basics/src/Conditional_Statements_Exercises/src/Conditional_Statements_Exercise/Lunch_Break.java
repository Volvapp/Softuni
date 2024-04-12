package Conditional_Statements_Exercise;

import java.util.Scanner;

public class Lunch_Break {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String serialName = scanner.nextLine();
        int episodeLength = Integer.parseInt(scanner.nextLine());
        int restTime = Integer.parseInt(scanner.nextLine());

        double lunch = restTime / 8.0;
        double rest = restTime / 4.0;
        double timeLeft = restTime - lunch - rest;

        double difference = Math.abs(timeLeft - episodeLength);

        if (timeLeft >= episodeLength) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", serialName, Math.ceil(difference));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", serialName, Math.ceil(difference));

        }
    }
}
