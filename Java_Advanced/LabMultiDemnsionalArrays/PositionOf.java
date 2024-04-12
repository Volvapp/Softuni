package LabMultiDemnsionalArrays;

import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] columnData = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {

                matrix[row][col] = Integer.parseInt(columnData[col]);
            }
        }
        int search = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (search == matrix[row][col]){
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }if (!isFound){
            System.out.println("not found");
        }
    }
}
