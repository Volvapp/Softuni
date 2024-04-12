package exerciseArrays;

import java.util.Arrays;
import java.util.Scanner;

public class equalSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        boolean isFound = false;


        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentNum = numbers[index];
            int rightSum = 0;
            int leftSum = 0;


            for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                leftSum += numbers[leftIndex];

            }
            for (int rightIndex = index + 1; rightIndex <= numbers.length - 1; rightIndex++) {
                rightSum += numbers[rightIndex];

            }if (rightSum == leftSum){
                System.out.println(index);
                isFound = true;
            }
        }if (!isFound){
            System.out.println("no");
        }
    }
}