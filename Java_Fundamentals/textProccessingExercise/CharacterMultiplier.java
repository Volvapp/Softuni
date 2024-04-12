package textProccessingExercise;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int result = 0;

            String firstWord = input[0];
            String secondWord = input[1];
            int counter = 0;
            char firstSymbol = ' ';
            char secondSymbol = ' ';
            if (firstWord.length() > secondWord.length()) {
                for (int j = 0; j < secondWord.length(); j++) {
                     firstSymbol = firstWord.charAt(j);
                     secondSymbol = secondWord.charAt(j);
                    result += firstSymbol * secondSymbol;
                    counter = j;
                }
                for (int k = 1; k < firstWord.length() - counter; k++) {
                    result += firstWord.charAt(counter + k);
                }
            } else {
                for (int j = 0; j < firstWord.length() ; j++) {
                    firstSymbol = firstWord.charAt(j);
                    secondSymbol = secondWord.charAt(j);
                    result += firstSymbol * secondSymbol;
                    counter = j;
                }
                for (int k = 1; k < secondWord.length() - counter; k++) {
                    result += secondWord.charAt(counter + k);
                }
            }
        System.out.println(result);
        }
    }

