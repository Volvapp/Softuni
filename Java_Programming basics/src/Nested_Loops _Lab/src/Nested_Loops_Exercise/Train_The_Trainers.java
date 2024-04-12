package Nested_Loops_Exercise;

import java.util.Scanner;

public class Train_The_Trainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());
        double allGrades = 0;
        int countGrades = 0;

        String input = scanner.nextLine();
        while (!input.equals("Finish")) {
            String presentation = input;
            double currentGradeSum = 0;
            for (int i = 1; i <= countPeople; i++) {
                double currentGrade = Double.parseDouble(scanner.nextLine());
                countGrades++;
                currentGradeSum += currentGrade;
            }
            allGrades += currentGradeSum;
            double averageGrade = currentGradeSum / countPeople;
            System.out.printf("%s - %.2f.%n",presentation, averageGrade);
            input = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", allGrades / countGrades);
    }
}
