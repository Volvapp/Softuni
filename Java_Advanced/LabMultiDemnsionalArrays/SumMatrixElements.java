package LabMultiDemnsionalArrays;

import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String[] rowsAndCols = scanner.nextLine().split(", ");

       int rows = Integer.parseInt(rowsAndCols[0]);
       int cols = Integer.parseInt(rowsAndCols[1]);

        System.out.println(rows);
        System.out.println(cols);

        int[][] data = new int[rows][cols];

        //int sum = 0;
        for (int row = 0; row < rows; row++) {
            String[] columnData = scanner.nextLine().split(", ");

            for (int col = 0; col < cols; col++) {
                //sum += Integer.parseInt(columnData[col]);
                data[row][col] = Integer.parseInt(columnData[col]);
            }
        }
        //System.out.println(sum); // TODO

        int sum = 0;

        for (int row = 0; row < data.length; row++) {

            for (int col = 0; col < data.length; col++) {
                sum += col;
            }
        }
        System.out.println(sum);
    }
}
