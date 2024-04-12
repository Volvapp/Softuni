package StackQueueLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class printerQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                String firstTask  = printerQueue.poll();

                if (firstTask == null){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled " +  firstTask);
                }

            } else {
                printerQueue.offer(input);

            }
            input = scanner.nextLine();
        }
        while (!printerQueue.isEmpty()){
            System.out.println(printerQueue.poll());
        }

    }
}
