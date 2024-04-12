package moreExerciseDataTypesAndVariables;

import java.util.Scanner;

public class dataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int letterCounter = 0;
        boolean isNumber = false;
        while (!command.equals("END")) {
            String text = String.valueOf(command);
            letterCounter = command.length();

//            if (text.equals("true") || text.equals("false")) {
//                System.out.printf("%s is boolean type.%n", text);
//            } else if (letterCounter == 1 ) {
//                System.out.printf("%s is character type.%n", text);
//            } else if (letterCounter > 1) {
//                System.out.printf("%s is string type.%n", text);
//            } else if (Double.parseDouble(command) % 1 == 0) {
//                System.out.printf("%.0f is integer type.%n", Double.parseDouble(command));
//            } else if (Double.parseDouble(command) % 1 != 0) {
//                System.out.printf("%.1f is floating point type.%n", Double.parseDouble(command));
//            }

            command = scanner.nextLine();
        }
    }
}
