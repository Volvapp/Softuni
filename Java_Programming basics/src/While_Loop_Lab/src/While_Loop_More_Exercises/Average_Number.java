package While_Loop_More_Exercises;

import java.util.Scanner;

public class Average_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbers = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        double allNum = 0;
        double average = 0;
        int num = numbers;
        while (counter <= num) {

            if (counter >= 1) {
                allNum = allNum + numbers;
            }

            if (num == counter) {
                break;
            }

            counter++;
            numbers = Integer.parseInt(scanner.nextLine());

        }

        average = allNum / counter;
        System.out.printf("%.2f", average);
    }
}
