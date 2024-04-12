package StackQueueLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class browserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> history = new ArrayDeque<>();

        String input = scanner.nextLine();


        while (!input.equals("Home")) {

            if (input.equals("back")) {

                if (history.size() == 1 || history.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
                    history.pop();

            } else {
                history.push(input);
            }

            System.out.println(history.peek());

            input = scanner.nextLine();
        }
    }
}
