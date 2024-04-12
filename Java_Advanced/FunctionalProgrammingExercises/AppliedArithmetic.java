package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> addFunc = list -> list.stream()
                .map(num -> num += 1)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> multiplyFunc = list -> list.stream()
                .map(num -> num *= 2)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> subtractFunc = list -> list.stream()
                .map(num -> num -= 1)
                .collect(Collectors.toList());

        Consumer<List<Integer>> printFunc = list -> list.forEach(number -> System.out.print(number + " "));


        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {

                case "add":
                    numbers = addFunc.apply(numbers);
                    break;

                case "multiply":
                    numbers = multiplyFunc.apply(numbers);
                    break;

                case "subtract":
                    numbers = subtractFunc.apply(numbers);
                    break;

                case "print":
                    printFunc.accept(numbers);
                    System.out.println();
                    break;

            }


            command = scanner.nextLine();
        }
    }
}
