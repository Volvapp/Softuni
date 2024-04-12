package exerciseAssociativeArrays;

import java.util.*;

public class legendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> validItems = new LinkedHashMap<>();
        validItems.put("shards", 0);
        validItems.put("fragments", 0);
        validItems.put("motes", 0);
        Map<String, Integer> junkItems = new LinkedHashMap<>();
        String[] command = scanner.nextLine().split("\\s+");
        int motes = 0;
        int fragments = 0;
        int shards = 0;
        boolean isObtained = false;
        while (true) {

            for (int i = 1; i <= command.length; i++) {

                if (i % 2 != 0) {
                    String material = command[i].toLowerCase();
                    Integer value = Integer.valueOf(command[i - 1]);
                    switch (material) {
                        case "shards":
                            shards += value;
                            break;
                        case "fragments":
                            fragments += value;
                            break;
                        case "motes":
                            motes += value;
                            break;
                    }
                    if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                        if (!validItems.containsKey(material)) {
                            validItems.put(material, value);
                        } else {
                            validItems.put(material, validItems.get(material) + value);
                        }
                    } else {
                        if (!junkItems.containsKey(material)) {
                            junkItems.put(material, value);
                        } else {
                            junkItems.put(material, junkItems.get(material) + value);
                        }
                    }
                    if (shards >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        validItems.put(material, validItems.get(material) - 250);
                        isObtained = true;
                        break;
                    } else if (fragments >= 250) {
                        System.out.println("Valanyr obtained!");
                        validItems.put(material, validItems.get(material) - 250);
                        isObtained = true;
                        break;
                    } else if (motes >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        validItems.put(material, validItems.get(material) - 250);
                        isObtained = true;
                        break;
                    }

                }
            }
            if (isObtained) {
                break;
            }
            command = scanner.nextLine().split("\\s+");
        }
        for (Map.Entry<String, Integer> entry : validItems.entrySet()) {

            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : junkItems.entrySet()) {

            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
}
