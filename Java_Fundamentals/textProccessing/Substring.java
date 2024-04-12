package textProccessing;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String excludedWord = scanner.nextLine();
        String word = scanner.nextLine();

        int index = word.indexOf(excludedWord);

        while (index != -1){
            word = word.replace(excludedWord, "");

            index = word.indexOf(excludedWord);
        }
        System.out.println(word);
    }
}
