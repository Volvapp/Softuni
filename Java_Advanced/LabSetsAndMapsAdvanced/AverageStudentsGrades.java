package LabSetsAndMapsAdvanced;

import java.lang.reflect.Array;
import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());

        TreeMap<String, LinkedHashMap<String, Double>> studentsData = new TreeMap<>();
        for (int i = 0; i < countStudents; i++) {
            String[] currentData = scanner.nextLine().split("\\s+");
            String currentName = currentData[0];
            double currentGrade = Double.parseDouble(currentData[1]);

            if (!studentsData.containsKey(currentName)) {
                studentsData.put(currentName, new LinkedHashMap<>());
            }
            Map<String, Double> grades = studentsData.get(currentName);
            if (!grades.containsKey(currentName)) {
                grades.put(String.valueOf(currentGrade), currentGrade);
            } else {
                grades.put(String.valueOf(currentGrade), currentGrade + currentGrade / grades.size());
            }
        }
        for (String element : studentsData.keySet()) {
            double sum = 0;
            int counter = 0;
            Map<String, Double> tempMap = studentsData.get(element);
            System.out.print(element + " -> ");
            for (String elem : tempMap.keySet()) {
                sum += Double.parseDouble(elem);
                System.out.printf("%.2f ", Double.parseDouble(elem));
                counter++;
            }
            double averageGrade = sum / counter;
            System.out.printf("(avg: %.2f)%n", averageGrade);

        }
    }
}
