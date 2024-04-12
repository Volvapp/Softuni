package methodsExercise;

import java.util.Scanner;

public class topNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            if (isDivisibleBy8(i) && isOdd(i)){
                System.out.println(i);
            }
        }
    }

    public static boolean isDivisibleBy8(int num) {
        int sumDigits = 0;
        while (num > 0){
            int lastDigit = num % 10;
            sumDigits += lastDigit;
            num = num / 10;
        }

        return sumDigits % 8 == 0;
    }
    public static boolean isOdd (int num){
        while (num > 0){
            int lastDigit = num % 10;
            if (lastDigit % 2 != 0){
                return true;
            }else {
                num = num / 10;
            }
        }
     return false;
    }
}
