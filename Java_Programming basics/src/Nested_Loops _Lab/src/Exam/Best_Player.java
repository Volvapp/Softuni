package Exam;

import java.util.Scanner;

public class Best_Player {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerName = scanner.nextLine();

        int goalsPerPlayer = 0;
        String playerName2 = "";

        while (!playerName.equals("END")) {
            int goalsScored = Integer.parseInt(scanner.nextLine());
            if (goalsPerPlayer < goalsScored) {
                goalsPerPlayer = goalsScored;
                playerName2 = playerName;

            }
            if (goalsScored >= 10) {
                break;
            }
                playerName = scanner.nextLine();
        }

        System.out.printf("%s is the best player!%n", playerName2);
        if (goalsPerPlayer >= 3) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!%n", goalsPerPlayer);
        } else {
            System.out.printf("He has scored %d goals.", goalsPerPlayer);
        }
    }
}
