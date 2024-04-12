package methodsExercise;

import java.util.Scanner;

public class addAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        int sum = sum(num1, num2);
        int subtract = subtraction(sum, num3);
        System.out.println(subtract);
    }

    public static int sum(int num1, int num2) {

        return (num1 + num2);
    }
    public static int subtraction(int num1, int num2){
        return num1 - num2;
    }
}
