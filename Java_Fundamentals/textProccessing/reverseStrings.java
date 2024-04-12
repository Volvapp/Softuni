package textProccessing;

import java.util.Scanner;

public class reverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String currentWord = command;
            StringBuilder newWord = new StringBuilder();
            for (int i = command.length() - 1; i >= 0; i--) {
                char currentSymbol = command.charAt(i);
                newWord.append(currentSymbol);
            }
            System.out.println(currentWord + " = " + newWord);

            command = scanner.nextLine();
        }
    }
}
