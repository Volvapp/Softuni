package textProccessing;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] command = scanner.nextLine().split("\\s+");

        for (int i = 0; i < command.length; i++) {
            String currentWord = command[i];
            int count = currentWord.length();
            String repeatWord = repeatString(currentWord, count);
            System.out.print(repeatWord);
        }

    }
    public static String repeatString(String word, int length){
        String result = "";

        for (int i = 0; i < length; i++) {
            result += word;
        }
        return result;
    }
}
