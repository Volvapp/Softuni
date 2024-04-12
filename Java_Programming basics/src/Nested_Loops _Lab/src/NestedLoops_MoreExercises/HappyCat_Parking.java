package NestedLoops_MoreExercises;

import java.util.Scanner;

public class HappyCat_Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countDays = Integer.parseInt(scanner.nextLine());
        int countHoursPerDay = Integer.parseInt(scanner.nextLine());
        double cost = 0;
        int dayCounter = 0;


        for (int i = 1; i <= countDays; i++) {
            double eachDayCost = 0;
            dayCounter++;
            System.out.printf("Day: %d - ", dayCounter );
            for (int j = 1; j <= countHoursPerDay; j++) {

                if (i % 2 == 0 && j % 2 != 0) {
                    eachDayCost = eachDayCost + 2.5;
                    cost = cost + 2.5;
                } else if (i % 2 != 0 && j % 2 == 0) {
                    cost = cost + 1.25;
                    eachDayCost = eachDayCost + 1.25;
                } else {
                    cost = cost + 1;
                    eachDayCost = eachDayCost + 1;
                }
            }
            System.out.printf("%.2f leva %n", eachDayCost);
        }
        System.out.printf("Total: %.2f leva", cost);
    }
}
