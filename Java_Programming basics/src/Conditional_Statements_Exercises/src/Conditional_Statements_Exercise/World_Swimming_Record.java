package Conditional_Statements_Exercise;

import java.util.Scanner;

public class World_Swimming_Record {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordSeconds = Double.parseDouble(scanner.nextLine());
        double meters = Double.parseDouble(scanner.nextLine());
        double timeForUnits = Double.parseDouble(scanner.nextLine());

        double allTime = meters * timeForUnits;

        double resistanceTime = Math.floor(meters / 15) * 12.5;
        double totalTime = allTime + resistanceTime;

        if (totalTime < recordSeconds) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        } else {

            System.out.printf("No, he failed! He was %.2f seconds slower.", totalTime - recordSeconds);

        }
    }
}
