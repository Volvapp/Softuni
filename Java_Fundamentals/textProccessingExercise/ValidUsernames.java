package textProccessingExercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(", ");

        for (String username : words) {
            if (isValidName(username)) {
                System.out.println(username);
            }

        }
    }

    public static boolean isValidName(String username) {
        boolean isValidLength = username.length() >= 3 && username.length() <= 16;

        boolean isValidContent = false;
        for (char symbol : username.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }
        }
        isValidContent = true;

        return isValidLength && isValidContent;
    }
}
