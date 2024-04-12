package exerciseArrays;

import java.util.Scanner;

public class zigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String [] firstArray = new String[n];
        String [] secondArray = new String[n];

        for (int row = 1; row <= n; row++) {

           String [] numbers = scanner.nextLine().split(" ");
           String firstNum = numbers[0];
           String secondNum = numbers[1];

           if (row % 2 == 0){
                secondArray[row - 1] = firstNum;
                firstArray[row - 1] = secondNum;
           }else {
                secondArray[row - 1] = secondNum;
                firstArray[row - 1] = firstNum;
           }
        }
        System.out.println(String.join(" ", firstArray));
        System.out.println(String.join(" ",secondArray));
    }
}
