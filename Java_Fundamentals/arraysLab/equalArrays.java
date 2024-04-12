package arraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class equalArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numArrOne = Arrays.stream(scanner.nextLine()
                        .split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int[] numArrTwo = Arrays.stream(scanner.nextLine()
                        .split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;
        int index = 0;
        boolean isIdentical = true;
        for (int i = 0; i < numArrOne.length; i++) {
            int firstNum = numArrOne[i];
            int secondNum = numArrTwo[i];
            if (firstNum == secondNum) {
                sum += firstNum;


            } else {
                index = i;
                isIdentical = false;
                break;
            }

        }
        if (isIdentical) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", index);
        }
    }
}
