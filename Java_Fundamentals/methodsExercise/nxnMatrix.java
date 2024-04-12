package methodsExercise;

import java.util.Scanner;

public class nxnMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printMatrix(n);
    }

    public static void printMatrix(int n) {
        for (int rows = 1; rows <= n; rows++) {

            for (int columns = 1; columns <= n; columns++) {
                System.out.print(n + " ");

            }System.out.println();
        }
    }
}
