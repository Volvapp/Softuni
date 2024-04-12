package methodsExercise;

import java.util.Scanner;

public class vowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        System.out.println(vowelsCount(word));
    }

    public static String vowelsCount(String word) {
        String lowerCase = word.toLowerCase();
        int counter = 0;
        for (char symbol : lowerCase.toCharArray()) {
            if (symbol == 'a' || symbol == 'e'
                    || symbol == 'u' || symbol == 'i'
                    || symbol == 'o') {
                counter++;
            }
        }return String.valueOf(counter);
    }
}
