package textProccessingExercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        for (char symbol : input.toCharArray()) {
            System.out.print((char) (symbol + 3));
        }
    }
}
