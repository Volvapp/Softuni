package Conditional_Statements_Exercise;

import java.util.Scanner;

public class Time_15_Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initHours = Integer.parseInt(scanner.nextLine());
        int initMinutes = Integer.parseInt(scanner.nextLine());
        int allMin = (initHours * 60) + initMinutes + 15;

        int hours = allMin / 60;
        int minutes = allMin % 60;

        if (hours > 23){
            hours = 0;
        }

        System.out.printf("%d:%02d", hours , minutes);
    }
}
