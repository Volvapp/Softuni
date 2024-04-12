package textProccessing;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(",+\\s+");

        String text = scanner.nextLine();

        for (int i = 0; i < bannedWords.length; i++) {
            int indexOfBanned = text.indexOf(bannedWords[i]);
            int countLetters = bannedWords[i].split("").length;
            while (indexOfBanned != -1){
                String symbol = "*";
               text = text.replace(bannedWords[i], symbol.repeat(countLetters));

                indexOfBanned = text.indexOf(bannedWords[i]);
            }
        }
        System.out.println(text);
    }
}
