package MidExam;

import java.util.*;
import java.util.stream.Collectors;

public class ApocalypsePreparation {

    public static final int PATCH = 30;
    public static final int BANDAGE = 40;
    public static final int MEDKIT = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listTextiles = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> listMedicament = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> textileQueue = new ArrayDeque<>(listTextiles);
        Collections.reverse(listMedicament);
        ArrayDeque<Integer> medicamentStack = new ArrayDeque<>(listMedicament);

        int patchCount = 0;
        int bandageCount = 0;
        int medKitCount = 0;

        TreeMap<String, Integer> itemsCreated = new TreeMap<>();

        while (!textileQueue.isEmpty() && !medicamentStack.isEmpty()) {

            int currentTextile = textileQueue.poll();
            int currentMedicament = medicamentStack.pop();

            int sum = currentTextile + currentMedicament;


            if (sum == PATCH) {
                patchCount++;
                itemsCreated.put("Patch", patchCount);

            } else if (sum == BANDAGE) {
                bandageCount++;
                itemsCreated.put("Bandage", bandageCount);

            } else if (sum == MEDKIT) {
                medKitCount++;
                itemsCreated.put("MedKit", medKitCount);

            } else if (sum > MEDKIT) {
                medKitCount++;
                itemsCreated.put("MedKit", medKitCount);
                medicamentStack.push(medicamentStack.poll() + sum - MEDKIT);

            } else {
                medicamentStack.push(currentMedicament + 10);

            }
        }

        if (medicamentStack.isEmpty() && textileQueue.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");

        } else if (medicamentStack.isEmpty()) {
            System.out.println("Medicaments are empty.");

        } else {
            System.out.println("Textiles are empty.");

        }
        itemsCreated.entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));


        if (!medicamentStack.isEmpty()) {
            System.out.print("Medicaments left: ");
            System.out.print(String.valueOf(medicamentStack).replaceAll("[\\[\\]]", ""));
        }
        if (!textileQueue.isEmpty()) {
            System.out.print("Textiles left: ");
            System.out.print(String.valueOf(textileQueue).replaceAll("[\\[\\]]", ""));
        }
    }
}
