package For_Loop_More_Exercises;

import java.util.Scanner;

public class Game_of_Intervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int turnCount = Integer.parseInt(scanner.nextLine());
        double numberInterval = 0;
        double result = 0;
        //•	От 0 до 9  20 % от числото
        //•	От 10 до 19  30 % от числото
        //•	От 20 до 29  40 % от числото
        //•	От 30 до 39  50 точки
        //•	От 40 до 50  100 точки
        //•	Невалидно число  резултата се дели на 2
        double counter9 = 0;
        double counter19 = 0;
        double counter29 = 0;
        double counter39 = 0;
        double counter49 = 0;
        double counterInvalid = 0;

        for (int i = 0; i < turnCount; i++) {
            numberInterval = Double.parseDouble(scanner.nextLine());

            if (numberInterval < 0 || numberInterval > 50) {
                result = result / 2;
                counterInvalid++;
            } else if (numberInterval <= 9) {
                result += numberInterval * 0.20;
                counter9++;
            } else if (numberInterval <= 19) {
                result += numberInterval * 0.30;
                counter19++;
            } else if (numberInterval <= 29) {
                result = result + numberInterval * 0.40;
                counter29++;
            } else if (numberInterval <= 39) {
                result += 50;
                counter39++;
            } else {
                result += 100;
                counter49++;
            }
        }
        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", counter9 / turnCount * 100);
        System.out.printf("From 10 to 19: %.2f%%%n", counter19 / turnCount * 100);
        System.out.printf("From 20 to 29: %.2f%%%n", counter29 / turnCount * 100);
        System.out.printf("From 30 to 39: %.2f%%%n", counter39 / turnCount * 100);
        System.out.printf("From 40 to 50: %.2f%%%n", counter49 / turnCount * 100);
        System.out.printf("Invalid numbers: %.2f%%", counterInvalid / turnCount * 100);

    }
}
