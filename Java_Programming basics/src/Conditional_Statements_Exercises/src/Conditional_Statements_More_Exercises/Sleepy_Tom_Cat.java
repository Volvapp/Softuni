package Conditional_Statements_More_Exercises;

import java.util.Scanner;

public class Sleepy_Tom_Cat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int restDays = Integer.parseInt(scanner.nextLine());
        int workPlayTimeMin = 63;
        int restDaysPlayTimeMin = 127;
        int yearDays = 365;

        int tomNormPlayTime = 30000;

        int yearWorkDays = yearDays - restDays;
        int playTimeDuringWork = yearWorkDays * workPlayTimeMin;
        int playTimeDuringRest = restDays * restDaysPlayTimeMin;
        int totalYearlyMinutes = playTimeDuringWork + playTimeDuringRest;
        int dif = tomNormPlayTime - totalYearlyMinutes;
        int convertHours = dif / 60;
        int convertMinutes = dif % 60;
        int absolute1 = Math.abs(convertHours);
        int absolute2 = Math.abs(convertMinutes);

        if (tomNormPlayTime < totalYearlyMinutes){
            System.out.printf("Tom will run away\n" +
            absolute1 + " hours and " + absolute2 + " minutes more for play");

        }else System.out.printf("Tom sleeps well\n" +
                absolute1 + " hours and " + absolute2 + " minutes less for play");
    }
}
