package For_Loop_Exercise;

import java.util.Scanner;

public class Tennis_Ranklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countTournaments = Integer.parseInt(scanner.nextLine());
        int initPoints = Integer.parseInt(scanner.nextLine());
        int points = 0;
        int countWins = 0;
        for (int i = 1; i <= countTournaments; i++) {
            String type = scanner.nextLine();

            switch (type) {
                case "W":
                    points = points + 2000;
                    countWins += 1;
                    break;
                case "F":
                    points = points + 1200;
                    break;
                case "SF":
                    points = points + 720;
                    break;
            }
        }
        System.out.printf("Final points: %d%n", initPoints + points);
        System.out.printf("Average points: %d%n", points / countTournaments);
        System.out.printf("%.2f%%", countWins * 1.0 / countTournaments * 100);
    }
}
