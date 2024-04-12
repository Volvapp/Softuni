package AdvancedMidExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, scanner, rows);

        int playerRow = -1;
        int playerCol = -1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 'Y') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        List<String> moves = new ArrayList<>();

        String inputCommands = scanner.nextLine();

        while (!inputCommands.equals("Finish")) {

            switch (inputCommands) {
                case "up":
                    if (playerRow - 1 >= 0 && matrix[playerRow - 1][playerCol] != 'T') {

                        playerRow--;

                        moves.add("up");
                    }
                    break;
                case "down":
                    if (playerRow + 1 < rows && matrix[playerRow + 1][playerCol] != 'T') {

                        playerRow++;

                        moves.add("down");
                    }
                    break;
                case "right":
                    if (playerCol + 1 < cols && matrix[playerRow][playerCol + 1] != 'T') {
                        playerCol++;

                        moves.add("right");
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0 && matrix[playerRow][playerCol - 1] != 'T') {

                        playerCol--;

                        moves.add("left");
                    }
                    break;
            }


            inputCommands = scanner.nextLine();
        }

        if (matrix[playerRow][playerCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");


            System.out.print(String.join(", ", moves));

        } else {
            System.out.println("The map is fake!");
        }
    }

    public static void fillMatrix(char[][] matrix, Scanner scanner, int rows) {

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }
}