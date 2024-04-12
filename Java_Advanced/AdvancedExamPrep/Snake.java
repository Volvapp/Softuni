package AdvancedExamPrep;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int snakeRow = -1;
        int snakeCol = -1;

        int firstBurrowRow = -1;
        int firstBurrowCol = -1;

        int secondBurrowRow = -1;
        int secondBurrowCol = -1;

        int counter = 0;
        String[][] matrix = new String[n][n];
        for (int row = 0; row < n; row++) {
            String[] colData = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = colData[col];
                if (matrix[row][col].equals("S")) {
                    snakeRow = row;
                    snakeCol = col;
                } else if (matrix[row][col].equals("B")) {
                    if (counter == 0) {
                        firstBurrowRow = row;
                        firstBurrowCol = col;
                        counter++;
                    } else {
                        secondBurrowRow = row;
                        secondBurrowCol = col;
                    }
                }
            }
        }
        int score = 0;
        String commands = scanner.nextLine();
        while (true) {

            matrix[snakeRow][snakeCol] = ".";

            switch (commands) {

                case "up":
                    snakeRow--;
                    break;

                case "down":
                    snakeRow++;
                    break;

                case "left":
                    snakeCol--;
                    break;

                case "right":
                    snakeCol++;
                    break;
            }

            if (isOutOfField(snakeRow, snakeCol, matrix, n)) {
                System.out.printf("Game over!%n" +
                        "Food eaten: %d%n", score);
                printMatrix(matrix, n);
                return;
            }
            if (matrix[snakeRow][snakeCol].equals("B")) {
                if (snakeRow == firstBurrowRow && snakeCol == firstBurrowCol) {
                    matrix[snakeRow][snakeCol] = ".";
                    snakeRow = secondBurrowRow;
                    snakeCol = secondBurrowCol;
                } else if (snakeRow == secondBurrowRow && snakeCol == secondBurrowCol) {
                    matrix[snakeRow][snakeCol] = ".";
                    snakeRow = firstBurrowRow;
                    snakeCol = firstBurrowCol;
                }
            } else if (matrix[snakeRow][snakeCol].equals("*")) {
                score++;
                if (score >= 10){
                    break;
                }
            }
            commands = scanner.nextLine();
        }
        System.out.printf("You won! You fed the snake.%n" +
                "Food eaten: %d%n", score);
        matrix[snakeRow][snakeCol] = "S";
        printMatrix(matrix, n);
    }

    private static boolean isOutOfField(int snakeRow, int snakeCol, String[][] matrix, int n) {
        if (snakeRow >= matrix.length || snakeRow < 0 || snakeCol >= matrix[n - 1].length || snakeCol < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void printMatrix(String[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
