package textProccessingExercise;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstNum = new BigInteger(scanner.nextLine());
        BigInteger multiplier = new BigInteger(scanner.nextLine());
        BigInteger result = firstNum.multiply(multiplier);
        System.out.println(result);
    }
}
