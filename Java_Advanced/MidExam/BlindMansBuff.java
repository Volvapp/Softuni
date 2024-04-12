package MidExam;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        int playerRow = -1;
        int playerCol = -1;

        int playerCounter = 0;

        for (int row = 0; row < rows; row++) {
            String[] colData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = colData[col];

                if (matrix[row][col].equals("B")) {
                    playerRow = row;
                    playerCol = col;
                }
                if (matrix[row][col].equals("P")){
                    playerCounter++;
                }
            }
        }

        String command = scanner.nextLine();

        int movesMade = 0;
        int playersTouched = 0;

        while (!command.equals("Finish") && playerCounter != 0) {

            switch (command){

                case "up":
                    if (playerRow - 1 >= 0 && !matrix[playerRow - 1][playerCol].equals("O")){
                        playerRow--;
                        movesMade++;
                    }
                    break;

                case "down":
                    if (playerRow + 1 < matrix.length && !matrix[playerRow + 1][playerCol].equals("O")){
                        playerRow++;
                        movesMade++;
                    }
                    break;

                case "left":
                    if (playerCol - 1 >= 0 && !matrix[playerRow][playerCol - 1].equals("O")){
                        playerCol--;
                        movesMade++;
                    }
                    break;

                case "right":
                    if (playerCol + 1 < matrix[rows - 1].length && !matrix[playerRow][playerCol + 1].equals("O")){
                        playerCol++;
                        movesMade++;
                    }
                    break;

            }
            if (matrix[playerRow][playerCol].equals("P")){
                playersTouched++;
                matrix[playerRow][playerCol] = "-";
                playerCounter--;
            }

            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d " +
                "Moves made: %d", playersTouched, movesMade);
    }
}
