package NestedLoops_MoreExercises;

import java.util.Scanner;

public class Wedding_Seats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char lastSector = scanner.nextLine().charAt(0);
        int rowsInFirstSector = Integer.parseInt(scanner.nextLine());
        int placesCountOddRow = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int qwerty = 0;

        for (char i = 'A'; i <= lastSector; i++) {

            for (int j = 1; j <= rowsInFirstSector; j++) {
                if (j % 2 == 0) {
                    qwerty = 2;
                }
                else {
                    qwerty = 0;
                }
                for (char k = 'a'; k <= 'a' + placesCountOddRow - 1 + qwerty; k++) {

                    System.out.println("" + i + j + k);
                    count++;
                }

            }
            rowsInFirstSector++;
        }
        System.out.println(count);
    }

}



