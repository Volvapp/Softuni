package AdvancedExamPrep;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] directions = scanner.nextLine().split(",");

        String[][] matrix = new String[size][size];

        fillMatrix(matrix, scanner);

        int rowThief = -1;
        int colThief = -1;

        int money = 0;

        for (int row = 0; row < size; row++) {

            for (int col = 0; col < size; col++) {

                if (matrix[row][col].equals("D")) {

                    rowThief = row;
                    colThief = col;
                    break;
                }
            }
        }

        for (String direction : directions) {

            switch (direction) {

                case "left":
                    if (colThief - 1 < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");

                    } else {
                        matrix[rowThief][colThief] = "+";
                        colThief--;
                    }

                    break;

                case "right":
                    if (colThief + 1 >= size) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[rowThief][colThief] = "+";
                        colThief++;
                    }

                    break;

                case "up":
                    if (rowThief - 1 < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[rowThief][colThief] = "+";
                        rowThief--;
                    }
                    break;

                case "down":
                    if (rowThief + 1 >= size) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[rowThief][colThief] = "+";
                        rowThief++;
                    }
                    break;
            }
            if (matrix[rowThief][colThief].equals("$")) {

                int stolenMoney = rowThief * colThief;
                System.out.println("You successfully stole " + stolenMoney + "$.");
                money += stolenMoney;
                matrix[rowThief][colThief] = "D";

            } else if (matrix[rowThief][colThief].equals("P")) {

                System.out.println("You got caught with " + money + "$, and you are going to jail.");
                matrix[rowThief][colThief] = "#";
                printMatrix(matrix, size);
                return;

            } else if (matrix[rowThief][colThief].equals("+")) {
                matrix[rowThief][colThief] = "D";
            }
        }
        System.out.println("Your last theft has finished successfully with " + money + "$ in your pocket.");


        printMatrix(matrix, size);

    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static void printMatrix(String[][] matrix, int size) {

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
