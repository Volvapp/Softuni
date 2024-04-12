package AdvancedMidExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tasksList = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> threadsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> threadQueue = new ArrayDeque<>(threadsList);
        Collections.reverse(tasksList);
        ArrayDeque<Integer> taskStack = new ArrayDeque<>(tasksList);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (taskStack.contains(taskToKill)) {

            int currentThread = threadQueue.poll();
            int currentTask = taskStack.pop();

            if (currentTask == taskToKill) {
                threadQueue.offerFirst(currentThread);
                System.out.printf("Thread with value %d killed task %d%n", currentThread, currentTask);
                threadQueue.forEach(thread -> System.out.print(thread + " "));
                break;
            }
            if (currentThread < currentTask) {
                taskStack.push(currentTask);
            }

        }
    }
}

