package exerciseAssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class countCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine().replaceAll("\\s+", "");
        Map<Character, Integer> count = new LinkedHashMap<>();

        for (char symbol : words.toCharArray()) {
//            if (symbol == ' '){
//                continue;
//            }


            if (!count.containsKey(symbol)) {
                count.put(symbol, 1);
            } else {
                int currentCount = count.get(symbol);
                count.put(symbol, currentCount + 1);

            }
        }
        count.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    }
}
