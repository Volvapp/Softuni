package Exam_Prep;

import java.util.Scanner;

public class Easter_Egg_Battle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstPlayerEggsCount = Integer.parseInt(scanner.nextLine());
        int secondPlayerEggsCount = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("End of battle")) {
            if (command.equals("one")) {
                secondPlayerEggsCount--;
            } else if (command.equals("two")) {
                firstPlayerEggsCount--;
            }if (firstPlayerEggsCount == 0){
                System.out.printf("Player one is out of eggs. Player two has %d eggs left.", secondPlayerEggsCount);
                break;
            }else if (secondPlayerEggsCount == 0){
                System.out.printf("Player two is out of eggs. Player one has %d eggs left.", firstPlayerEggsCount);
                break;
            }

            command = scanner.nextLine();
        }if (command.equals("End of battle")){
            System.out.printf("Player one has %d eggs left.%n", firstPlayerEggsCount);
            System.out.printf("Player two has %d eggs left.", secondPlayerEggsCount);
        }
    }
}
