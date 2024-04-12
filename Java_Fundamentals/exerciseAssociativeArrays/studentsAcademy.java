package exerciseAssociativeArrays;


import java.util.*;

public class studentsAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> studentGrade = new LinkedHashMap<>();
        int countStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= countStudents; i++) {

            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentGrade.containsKey(name)) {
                studentGrade.put(name, new ArrayList<>());
            }
            studentGrade.get(name).add(grade);
        }
        Map<String, Double> averageGradeStudent = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : studentGrade.entrySet()) {
            String studentName = entry.getKey();
            List<Double> listGrades = entry.getValue();

            double averageGrade = getAverageGrade(listGrades);

            if (averageGrade >= 4.50) {
                averageGradeStudent.put(studentName, averageGrade);
            }
        }
        averageGradeStudent.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n",entry.getKey(),entry.getValue()));

    }

    private static double getAverageGrade(List<Double> listGrades) {
        double sumOfGrades = 0;
        for (double grade : listGrades) {
            sumOfGrades += grade;
        }
        return sumOfGrades / listGrades.size();
    }
}
