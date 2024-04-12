package StackQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();


            if (command.startsWith("1")) {
                stack.push(currentText.toString());
                String textToAppend = command.split("\\s+")[1];
                currentText.append(textToAppend);


            } else if (command.startsWith("2")) {

                stack.push(currentText.toString());
                int count = Integer.parseInt(command.split("\\s+")[1]);
                currentText.delete(currentText.length() - count, currentText.length());


            } else if (command.startsWith("3")) {
                int position = Integer.parseInt(command.split("\\s+")[1]);
                System.out.println(currentText.charAt(position - 1));


            } else if (command.equals("4")) {
                if (!stack.isEmpty()) {
                    String last = stack.pop();
                    currentText = new StringBuilder(last);
                }

            }
        }
    }
}
