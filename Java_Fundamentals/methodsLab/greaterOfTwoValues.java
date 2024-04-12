package methodsLab;

import java.util.Scanner;

public class greaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeValue = scanner.nextLine();
        switch (typeValue) {
            case "int":
                int firstNum = Integer.parseInt(scanner.nextLine());
                int secondNum = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(firstNum, secondNum));
                break;

            case "string":
                String firstValue = scanner.nextLine();
                String secondValue = scanner.nextLine();
                System.out.println(getMaxValue(firstValue, secondValue));
                break;

            case "char":
                char firstChar = scanner.nextLine().charAt(0);
                char secondChar = scanner.nextLine().charAt(0);
                System.out.println(getMax(firstChar, secondChar));
                break;

        }
    }

    public static int getMax(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            return firstNum;
        } else {
            return secondNum;
        }
    }

    public static String getMaxValue(String firstValue, String secondValue) {
        if (firstValue.compareTo(secondValue) > 0) {
            return firstValue;
        } else {
            return secondValue;
        }
    }

    public static Character getMax(char firstChar, char secondChar) {
        if (firstChar > secondChar) {
            return firstChar;
        } else {
            return secondChar;
        }
    }
}
