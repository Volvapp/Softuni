package exerciseDataTypesAndVariables;

import java.util.Scanner;

public class sumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int currentNum = 0;
        int result = 0;
        while (num > 0){
            currentNum = num % 10;
            num = num / 10;
            result = result + currentNum;
        }
        System.out.println(result);
    }
}
