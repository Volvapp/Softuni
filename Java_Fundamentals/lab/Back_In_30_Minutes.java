package lab;

import java.util.Scanner;

public class Back_In_30_Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inHour = Integer.parseInt(scanner.nextLine());
        int inMinutes = Integer.parseInt(scanner.nextLine());
        int allMinutes = (inHour * 60) + inMinutes + 30;

        int hour = allMinutes / 60;
        int minutes = allMinutes % 60;
        if (hour > 23) {
            hour = 0;
        }
        System.out.printf("%01d:%02d", hour, minutes);
    }
}
