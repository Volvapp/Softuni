package AdvancedMidExamPrep;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[rows][];

        int parisRow = -1;
        int parisCol = -1;


        for (int row = 0; row < rows; row++) {
            String[] colData = scanner.nextLine().split("");
            for (int col = 0; col < colData.length; col++) {
                matrix[row] = colData;
                if (matrix[row][col].equals("P")) {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        matrix[parisRow][parisCol] = "-";

        while (true) {
            String[] commands = scanner.nextLine().split("\\s+");
            int spartanRow = Integer.parseInt(commands[1]);
            int spartanCol = Integer.parseInt(commands[2]);

            matrix[spartanRow][spartanCol] = "S";

            energy--;

            switch (commands[0]) {

                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;

                    }
                    break;

                case "down":

                    if (parisRow + 1 < matrix.length) {
                        parisRow++;

                    }
                    break;

                case "right":
                    if (parisCol + 1 < matrix[rows - 1].length) {
                        parisCol++;

                    }
                    break;

                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;

                    }
                    break;
            }
            if (matrix[parisRow][parisCol].equals("H")) {
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energy);
                matrix[parisRow][parisCol] = "-";
                break;
            } else if (matrix[parisRow][parisCol].equals("S")) {
                if (energy >= 2) {
                    energy -= 2;
                    matrix[parisRow][parisCol] = "-";
                }
            }
            if (energy <= 0) {
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                matrix[parisRow][parisCol] = "X";
                break;

            }
        }
        printMatrix(matrix, rows);
    }

    private static void printMatrix(String[][] matrix, int rows) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[rows - 1].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
