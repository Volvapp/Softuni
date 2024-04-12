package For_Loop_Exercise;

import java.util.Scanner;

public class Half_Sum_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(scanner.nextLine());

            sum = sum + currentNum;

            if (currentNum > max){
                max = currentNum;
            }
        }
        int sumWithoutMaxNum = sum - max;
        if (max == sumWithoutMaxNum){
            System.out.printf("Yes \n" +
                    "Sum = %d", sumWithoutMaxNum);
        }else {
            System.out.printf("No \n" +
                    "Diff = %d", Math.abs(max - sumWithoutMaxNum));
        }
    }
}
