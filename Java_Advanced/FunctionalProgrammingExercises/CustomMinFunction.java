package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
//        option 1:
//        System.out.println(Collections.min(numbers));

//        option 2:
//        Consumer<List<Integer>> printNum = list -> System.out.println(Collections.min(list));
//        printNum.accept(numbers);

//        option 3:
//        Function<List<Integer>, Integer> getMinNum = list -> Collections.min(list);
//        System.out.println(getMinNum.apply(numbers));


    }
}
