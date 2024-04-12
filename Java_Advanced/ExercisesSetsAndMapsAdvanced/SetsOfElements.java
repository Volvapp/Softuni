package ExercisesSetsAndMapsAdvanced;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        int firstSetSize = Integer.parseInt(firstLine[0]);
        int secondSetSize = Integer.parseInt(firstLine[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();


        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        firstSet.retainAll(secondSet); //  TODO - VERY IMPORTANT
        firstSet.forEach(el -> System.out.print(el + " "));
    }
}
