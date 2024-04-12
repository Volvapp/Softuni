package exerciseAssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> map = new LinkedHashMap<>();
        while (!command.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!map.containsKey(command)) {
                map.put(command, quantity);
            } else {
                map.put(command, map.get(command) + quantity);
            }

            command = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}

