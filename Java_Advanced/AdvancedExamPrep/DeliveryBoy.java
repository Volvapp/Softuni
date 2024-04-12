package AdvancedMidExamPrep;

import java.util.Scanner;

public class DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        int boyRow = -1;
        int boyCol = -1;

        int initRow = -1;
        int initCol = -1;

        for (int row = 0; row < rows; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = input.split("")[col];
                if (matrix[row][col].equals("B")) {
                    boyRow = row;
                    boyCol = col;
                    initRow = row;
                    initCol = col;
                }
            }
        }

        while (true) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    if (boyRow - 1 >= 0) {
                        if (!matrix[boyRow - 1][boyCol].equals("*")) {
                            boyRow--;
                        }
                    } else {
                        outOfBounds(matrix, initRow, initCol);
                        return;
                    }
                    break;
                case "down":
                    if (boyRow + 1 < rows) {
                        if (!matrix[boyRow + 1][boyCol].equals("*")) {
                            boyRow++;
                        }
                    } else {
                        outOfBounds(matrix, initRow, initCol);
                        return;
                    }
                    break;
                case "right":
                    if (boyCol + 1 < cols) {
                        if (!matrix[boyRow][boyCol + 1].equals("*")) {
                            boyCol++;
                        }
                    } else {
                        outOfBounds(matrix, initRow, initCol);
                        return;
                    }
                    break;
                case "left":
                    if (boyCol - 1 >= 0) {
                        if (!matrix[boyRow][boyCol - 1].equals("*")) {
                            boyCol--;
                        }
                    } else {
                        outOfBounds(matrix, initRow, initCol);
                        return;
                    }
                    break;
            }
            if (matrix[boyRow][boyCol].equals("-")) {
                matrix[boyRow][boyCol] = ".";
            } else if (matrix[boyRow][boyCol].equals("P")) {
                matrix[boyRow][boyCol] = "R";
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            } else if (matrix[boyRow][boyCol].equals("A")) {
                matrix[boyRow][boyCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                printMatrix(matrix);
                return;
            }

        }
    }

    private static void outOfBounds(String[][] matrix, int initRow, int initCol) {
        System.out.println("The delivery is late. Order is canceled.");
        matrix[initRow][initCol] = " ";
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
