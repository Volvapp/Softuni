package StackQueueLab;

import java.util.*;

public class simpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();


        String[] expressionParts = expression.split("\\s+");
        List<String> partsList = Arrays.asList(expressionParts);

        Collections.reverse(partsList);

        for (String part : partsList) {
            stack.push(part);
        }
        while (stack.size() > 1) {

            int firstNum = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            int result;
            switch (operation) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                default:
                    return;
            }
            stack.push("" + result);
        }
        System.out.println(stack.peek());
    }
}
