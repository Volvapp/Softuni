package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

//        option 1:
//        Arrays.stream(names).forEach(name -> System.out.println(name));

//        option 2:
//        Consumer<String> printName = name -> System.out.println(name);
//
//        for (String name : names) {
//            printName.accept(name);
//        }

//        option 3:
//        Consumer<String[]> printArray = array -> {
//            for (String name : names) {
//                System.out.println(name);
//            }
//        };
//        printArray.accept(names);
    }
}
