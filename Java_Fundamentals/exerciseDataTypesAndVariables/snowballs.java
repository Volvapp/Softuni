package exerciseDataTypesAndVariables;

import java.util.Scanner;

public class snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSnowballs = Integer.parseInt(scanner.nextLine());
        double maxValue = Integer.MIN_VALUE;
        int snow = 0;
        int time = 0;
        int quality = 0;
        for (int i = 1; i <= numberOfSnowballs; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            int division = snowballSnow / snowballTime;
            double snowballValue = Math.pow(division, snowballQuality);

            if (maxValue < snowballValue) {
                maxValue = (snowballValue);
                snow = snowballSnow;
                time = snowballTime;
                quality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", snow, time, maxValue, quality);
    }
}
