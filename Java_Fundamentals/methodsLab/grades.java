package methodsLab;

import java.util.Scanner;

public class grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double gradeInput = Double.parseDouble(scanner.nextLine());

        printGradeInWord(gradeInput);
    }
    public static void printGradeInWord(double grade){
        if (grade >= 2 && grade <= 2.99){
            System.out.println("Fail");
        }else if (grade <= 3.49){
            System.out.println("Poor");
        }else if (grade <= 4.49){
            System.out.println("Good");
        }else if (grade <= 5.49){
            System.out.println("Very good");
        }else {
            System.out.println("Excellent");
        }
    }
}
