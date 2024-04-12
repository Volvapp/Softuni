package finalExamPrep;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> plantRarityMap = new LinkedHashMap<>();
        Map<String, Double> rateMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);
            //plantRarityMap.putIfAbsent(plant, 0);
            plantRarityMap.put(plant, rarity);
            rateMap.put(plant, 0.0);
        }
        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] command = input.split("[: -]+");
            String plant = command[1];

            if (!plantRarityMap.containsKey(plant)) {
                System.out.println("error");
            } else {
                switch (command[0]) {
                    case "Rate":
                        double rate = Double.parseDouble(command[2]);
                        if (rateMap.get(plant) == 0) {
                            rateMap.put(plant, rate);
                        }else {
                            double newRate = (rateMap.get(plant) + rate) / 2;
                            rateMap.put(plant, newRate);
                        }
                        break;
                    case "Update":
                        int rarity = Integer.parseInt(command[2]);
                        plantRarityMap.put(plant, rarity);
                        break;
                    case "Reset":
                        rateMap.put(plant, 0.0);
                        break;
                }
            }
            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        for (Map.Entry<String, Integer> entry : plantRarityMap.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",entry.getKey(),entry.getValue(),rateMap.get(entry.getKey()));
        }

    }
}
