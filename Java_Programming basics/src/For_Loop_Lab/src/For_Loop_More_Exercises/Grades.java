package For_Loop_More_Exercises;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsParticipating = Integer.parseInt(scanner.nextLine());
        double studentsGrades = 0;
        double studentGradesFail = 0;
        double studentsGrade3 = 0;
        double studentsGrade4 = 0;
        double studentsGradeTop = 0;
        double studentsGradesAverage = 0;
        double counterF = 0;
        double counter3 = 0;
        double counter4 = 0;
        double counterTop = 0;

        for (int i = 0; i < studentsParticipating; i++) {
            studentsGrades = Double.parseDouble(scanner.nextLine()); // per student

            if (studentsGrades < 3) {
                studentGradesFail += studentsGrades;
                counterF++;
            } else if (studentsGrades < 4) {
                studentsGrade3 += studentsGrades;
                counter3++;
            } else if (studentsGrades < 5) {
                studentsGrade4 += studentsGrades;
                counter4++;
            } else {
                studentsGradeTop += studentsGrades;
                counterTop++;
            }
        }

        counterF = counterF / studentsParticipating * 100;
        counter3 = counter3 / studentsParticipating * 100;
        counter4 = counter4 / studentsParticipating * 100;
        counterTop = counterTop / studentsParticipating * 100;
        studentsGradesAverage = (studentGradesFail + studentsGrade3 + studentsGrade4 + studentsGradeTop) / studentsParticipating;
        System.out.printf("Top students: %.2f%%%n", counterTop);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", counter4);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", counter3);
        System.out.printf("Fail: %.2f%%%n", counterF);
        System.out.printf("Average: %.2f", studentsGradesAverage);
    }
}
