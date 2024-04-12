package While_Loop_Exercise;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        int counter = 0;
        double coins = change * 100;
        while (coins > 0) {
            if (coins >= 200) {
                coins = coins - 200;
                counter++;
            } else if (coins >= 100) {
                coins = coins - 100;
                counter++;
            } else if (coins >= 50) {
                coins = coins - 50;
                counter++;
            } else if (coins >= 20) {
                coins = coins - 20;
                counter++;
            } else if (coins >= 10) {
                coins = coins - 10;
                counter++;
            } else if (coins >= 5) {
                coins = coins - 5;
                counter++;
            } else if (coins >= 2) {
                coins = coins - 2;
                counter++;
            } else if (coins >= 1) {
                coins = coins - 1;
                counter++;
            } else {
                break;
            }
        }
        System.out.println(counter);
    }
}
