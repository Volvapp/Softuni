package arraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class sumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


//        String[] inputArr = scanner.nextLine().split(" ");
//        int[] numArr = new int[inputArr.length];
//
//        for (int i = 0; i < numArr.length; i++) {
//            numArr[i] = Integer.parseInt(inputArr[i]);
//        }
//    }
//}


        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int evenSum = 0;
        for (int currentElement : numbersArr) {
            if (currentElement % 2 == 0) {
                evenSum += currentElement;
            }
        }
        System.out.printf("%d", evenSum);
    }
}