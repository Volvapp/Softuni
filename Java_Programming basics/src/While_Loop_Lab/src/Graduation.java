import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentName = scanner.nextLine();
        double averageGrades = 0;
        double counterForFails = 0;
        int counterForGrades = 0;

        while (counterForGrades != 12) {
            double currentGrades = Double.parseDouble(scanner.nextLine());

              if (currentGrades < 4) {
                counterForFails++;
            }
            if (counterForFails > 1) {
                break;
            }averageGrades += currentGrades;
            counterForGrades++;
        }
        if (counterForGrades == 12){
            System.out.printf("%s graduated. Average grade: %.2f", studentName, averageGrades / 12);
        } else {
            System.out.printf("%s has been excluded at %d grade", studentName, counterForGrades);
        }

    }
}