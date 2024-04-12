package Conditional_Statements_Exercise;

import java.util.Scanner;

public class Bonus_Score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int points = Integer.parseInt(scanner.nextLine());
        double bonusPoints = 0;

        if (points <= 100){
            bonusPoints = 5;

        }
        else if (points <= 1000) {
            bonusPoints = points * 0.20;

        }
        else {
            bonusPoints = points * 0.10;
        }
        if (points % 2 == 0){
            bonusPoints = bonusPoints + 1;
        }
        if (points % 10 == 5){
            bonusPoints = bonusPoints + 2;
        }
        double totalPoints = bonusPoints + points;

        System.out.printf("%.1f\n", bonusPoints);
        System.out.printf("%.1f", totalPoints);
    }
}
