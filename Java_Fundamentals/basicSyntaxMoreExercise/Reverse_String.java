package basicSyntaxMoreExercise;

import java.util.Scanner;

public class Reverse_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String word = "";
        for (int position = string.length() - 1; position >= 0; position--) {
            char currentPosition = string.charAt(position);
            word += currentPosition;
        }
        System.out.println(word);
    }
}
