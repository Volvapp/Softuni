package AdvancedExamPrep;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);

        int submarineRow = -1;
        int submarineCol = -1;

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        int damageCounter = 0;
        int battleShipCounter = 0;

        while (true) {


            matrix[submarineRow][submarineCol] = "-";
            if (command.equals("up")) {
                submarineRow--;
            } else if (command.equals("down")) {
                submarineRow++;
            } else if (command.equals("left")) {
                submarineCol--;
            } else if (command.equals("right")) {
                submarineCol++;
            }

            String position = matrix[submarineRow][submarineCol];

            switch (position) {

                case "-":
                    matrix[submarineRow][submarineCol] = "S";
                    break;
                case "*":
                    damageCounter++;
                    matrix[submarineRow][submarineCol] = "S";
                    if (damageCounter == 3) {
                        System.out.println("Mission failed, U-9 disappeared! Last known coordinates [" + submarineRow + ", " + submarineCol + "]!");
                        printMatrix(matrix);
                        return;
                    }
                    break;
                case "C":
                    matrix[submarineRow][submarineCol] = "S";
                    battleShipCounter++;
                    if (battleShipCounter == 3) {
                        System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                        printMatrix(matrix);
                        return;
                    }
                    break;
            }

            command = scanner.nextLine();
        }


    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = scanner.nextLine().split("");

        }


    }
}
