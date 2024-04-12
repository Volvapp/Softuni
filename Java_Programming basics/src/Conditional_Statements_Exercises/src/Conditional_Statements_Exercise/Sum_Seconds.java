package Conditional_Statements_Exercise;

import java.util.Scanner;

public class Sum_Seconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int totalTimeSec = first + second + third;

        int minutes = totalTimeSec / 60;
        int seconds = totalTimeSec % 60;

        //if (sec < 10) {
        // System.out.printf("%d:0%d", min, sec)
        // }
        System.out.printf("%d:%02d", minutes, seconds);
    }
}
