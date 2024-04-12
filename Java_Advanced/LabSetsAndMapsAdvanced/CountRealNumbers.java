package LabSetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> occurrences = new LinkedHashMap<>();


        String[] numbers = scanner.nextLine().split("\\s+");

        for (String num : numbers) {

            double currentNum = Double.parseDouble(num);

            if (occurrences.containsKey(currentNum)) {
                int count = occurrences.get(currentNum);
                occurrences.put(currentNum, count + 1);
            } else {
                occurrences.put(currentNum, 1);
            }
        }
        for (Double number : occurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", number, occurrences.get(number));
        }
    }
}
