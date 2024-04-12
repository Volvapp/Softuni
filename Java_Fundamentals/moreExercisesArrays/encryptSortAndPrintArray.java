package moreExercisesArrays;

import java.util.Scanner;

public class encryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfLines = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int vowels = 0;
        int consonants = 0;
        int[] arrayOfSums = new int[numOfLines];
        int temp = 0;
        for (int i = 0; i <= numOfLines; i++) {

            if (i >= 1) {
                sum = vowels + consonants;
                vowels = 0;
                consonants = 0;
                arrayOfSums[i - 1] = sum;
            }
            if (i == numOfLines) {
                for (int j = 0; j < numOfLines; j++) {
                    for (int k = j + 1; k < numOfLines; k++) {
                        if (arrayOfSums[j] > arrayOfSums[k]) {
                            temp = arrayOfSums[j];
                            arrayOfSums[j] = arrayOfSums[k];
                            arrayOfSums[k] = temp;
                        }
                    }
                }
                for (int l = 0; l < numOfLines; l++) {
                    System.out.println(arrayOfSums[l]);
                }
            }
            String[] names = scanner.nextLine().split("");
            for (String currentSymbol : names) {
                int charToNum = (currentSymbol.charAt(0));
                if (currentSymbol.charAt(0) == 'a' || currentSymbol.charAt(0) == 'e'
                        || currentSymbol.charAt(0) == 'u' || currentSymbol.charAt(0) == 'i'
                        || currentSymbol.charAt(0) == 'o' || currentSymbol.charAt(0) == 'A'
                        || currentSymbol.charAt(0) == 'E' || currentSymbol.charAt(0) == 'I'
                        || currentSymbol.charAt(0) == 'O' || currentSymbol.charAt(0) == 'U') {
                    vowels += charToNum * names.length;

                } else {
                    consonants += charToNum / names.length;
                }
            }
        }
    }
}