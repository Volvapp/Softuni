package labExceptionsAndErrorHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int lowerBound = 1;
        int upperBound = 100;

        List<Integer> nums = new ArrayList<>();

        while (nums.size() < 10) {
            try {
                lowerBound = readNumbers(lowerBound, upperBound);
                nums.add(lowerBound);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(nums.toString().replaceAll("[\\[\\]]", ""));

    }

    private static int readNumbers(int lowerBound, int upperBound) {
        String input = scanner.nextLine();
        int num = 0;
        try {
            num = Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid Number!");
        }
        if (num <= lowerBound || num >= upperBound) {
            throw new NumberFormatException(String.format("Your number is not in range %d - %d!", lowerBound, upperBound));
        }
        return num;
    }
}
