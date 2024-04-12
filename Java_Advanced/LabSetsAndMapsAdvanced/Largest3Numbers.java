package LabSetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (String elem : input) {
            numbers.add(Integer.parseInt(elem));
        }
        List<Integer> sorted = numbers.stream().sorted((l, r)-> r.compareTo(l)).collect(Collectors.toList());

        int limit = Math.min(sorted.size(), 3);
        for (int i = 0; i < limit; i++) {
            System.out.print(sorted.get(i) + " ");
        }
    }
}
