package For_Loop_More_Exercises;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());

        int doctors = 7;
        int treated = 0;
        int untreated = 0;

        for (int i = 1; i <= period; i++) {
            int patientsCount = Integer.parseInt(scanner.nextLine());

            if (i % 3 == 0) {
                if (untreated > treated) {
                    doctors++;
                }
            }
            if (patientsCount <= doctors){
                treated += patientsCount;
            }else {
                treated = treated + doctors;
                untreated = untreated + patientsCount - doctors;
            }
        }
        System.out.printf("Treated patients: %d.%n", treated);
        System.out.printf("Untreated patients: %d.", untreated);
    }
}
