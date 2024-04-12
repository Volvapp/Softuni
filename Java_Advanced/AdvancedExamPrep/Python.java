package AdvancedMidExamPrep;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dimensions = Integer.parseInt(scanner.nextLine());

        List<String> commands = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        char[][] field = new char[dimensions][dimensions];

        int snakeRow = -1;
        int snakeCol = -1;
        int pythonLength = 1;
        int foodCounter = 0;

        for (int row = 0; row < dimensions; row++) {
            String[] colData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < dimensions; col++) {
                field[row][col] = colData[col].charAt(0);

                if (field[row][col] == 's') {
                    snakeRow = row;
                    snakeCol = col;
                } else if (field[row][col] == 'f') {
                    foodCounter++;
                }
            }

        }

        boolean isKilled = false;

        for (String command : commands) {

            switch (command) {

                case "left":
                    if (snakeCol > 0) {
                        snakeCol--;
                    } else {
                        snakeCol = field.length - 1;
                    }
                    break;

                case "right":
                    if (snakeCol < field.length - 1) {
                        snakeCol++;
                    } else {
                        snakeCol = 0;
                    }
                    break;

                case "up":
                    if (snakeRow > 0) {
                        snakeRow--;
                    } else {
                        snakeRow = field.length - 1;
                    }
                    break;

                case "down":
                    if (snakeRow < field.length - 1) {
                        snakeRow++;
                    } else {
                        snakeRow = 0;
                    }
                    break;

            }
            if (field[snakeRow][snakeCol] == 'e') {
                isKilled = true;
            } else if (field[snakeRow][snakeCol] == 'f') {
                pythonLength++;
                foodCounter--;
            }
        }
        if (foodCounter == 0) {
            System.out.printf("You win! Final python length is %d", pythonLength);
        } else if (isKilled) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCounter);
        }
    }
}