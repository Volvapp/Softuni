package exerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class topIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" ")).mapToInt(Integer::parseInt)
                .toArray();

        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentNum = numbers[index];
            if (index == numbers.length - 1) {
                System.out.print(currentNum + " ");
                continue;
            }
            boolean isTop = false;
            for (int indexIn = index + 1; indexIn <= numbers.length - 1; indexIn++) {
                if (currentNum > numbers[indexIn]) {
                    isTop = true;
                } else {
                    isTop = false;
                    break;
                }
            }
            if (isTop) {
                System.out.print(currentNum + " ");
            }
        }
    }
}