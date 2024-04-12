package exerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class maxSequenceOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int counter = 1;
        int maxSequences = 0;

        int startIndex = 0;
        int bestStart = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                counter++;
            } else {
                counter = 1;
                startIndex = i;
            }
            if (maxSequences < counter) {
                maxSequences = counter;
                bestStart = startIndex;
            }

        }
        for (int i = bestStart; i < bestStart + maxSequences; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
