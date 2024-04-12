package AdvancedExamPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = (new Scanner(System.in));

        int n = Integer.parseInt(scanner.nextLine());
        String plateNum = scanner.nextLine();
        int km = 0;

        String[][] trace = new String[n][n];

        fillMatrix(trace, scanner);

        int currentRow = 0;
        int currentCol = 0;

        List<Integer> tunnelCoordinates = new ArrayList<>();

        findTunnels(trace, tunnelCoordinates);

        String direction = scanner.nextLine();
        int countTunnels = 0;
        while (!direction.equals("End")) {

            switch (direction) {

                case "left":
                    currentCol--;
                    break;

                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;

                case "down":
                    currentRow++;
                    break;

            }

            String movedPlace = trace[currentRow][currentCol];

            if (movedPlace.equals(".")) {
                km += 10;
            } else if (movedPlace.equals("T")) {
                countTunnels++;
                if (countTunnels == 1) {
                    currentRow = tunnelCoordinates.get(2);
                    currentCol = tunnelCoordinates.get(3);
                    km += 30;
                    trace[tunnelCoordinates.get(0)][tunnelCoordinates.get(1)] = ".";
                    trace[tunnelCoordinates.get(2)][tunnelCoordinates.get(3)] = ".";
                }
            } else if (movedPlace.equals("F")) {
                System.out.printf("Racing car %s finished the stage!%n", plateNum);
                km += 10;
                break;
            }

            direction = scanner.nextLine();
        }
        if (direction.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", plateNum);
        }
        System.out.println("Distance covered " + km + " km.");


        trace[currentRow][currentCol] = "C";
        printMatrix(trace);
    }


    private static void findTunnels(String[][] trace, List<Integer> tunnelCoordinates) {
        for (int row = 0; row < trace.length; row++) {
            for (int col = 0; col < trace.length; col++) {
                String currentElement = trace[row][col];
                if (currentElement.equals("T")) {
                    tunnelCoordinates.add(row);
                    tunnelCoordinates.add(col);
                }
            }
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
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
}
