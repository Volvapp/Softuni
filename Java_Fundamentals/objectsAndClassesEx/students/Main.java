package objectsAndClassesEx.students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        List<Student> studentsList = new ArrayList<>();


        for (int studentCount = 1; studentCount <= countStudents; studentCount++) {
            String data = scanner.nextLine();
            String firstName = data.split(" ")[0];
            String lastName = data.split(" ")[1];
            double grade = Double.parseDouble(data.split(" ")[2]);

            Student student = new Student(firstName, lastName, grade);

            studentsList.add(student);
        }
        studentsList.sort(Comparator.comparing(Student::getGrade).reversed());

        for (Student student : studentsList) {
            System.out.println(student.toString());
        }
    }
}
