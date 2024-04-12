import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        int officerRow = -1;
        int officerCol = -1;

        int firstMirrorRow = -1;
        int firstMirrorCol = -1;

        int secondMirrorRow = -1;
        int secondMirrorCol = -1;

        int counter = 0;

        for (int row = 0; row < n; row++) {
            String[] colData = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = colData[col];
                if (matrix[row][col].equals("A")) {
                    officerRow = row;
                    officerCol = col;
                } else if (matrix[row][col].equals("M") && counter == 0) {
                    firstMirrorRow = row;
                    firstMirrorCol = col;
                    counter++;
                } else if (counter == 1 && matrix[row][col].equals("M")) {
                    secondMirrorRow = row;
                    secondMirrorCol = col;
                }
            }
        }

        int bladesWorth = 0;

        matrix[officerRow][officerCol] = "-";
        while (bladesWorth < 65) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    officerRow--;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;

            }

            if (validation(matrix, officerRow, officerCol)) {
                if (matrix[officerRow][officerCol].equals("M")) {
                    if (officerRow == firstMirrorRow && officerCol == firstMirrorCol) {
                        matrix[officerRow][officerCol] = "-";
                        officerRow = secondMirrorRow;
                        officerCol = secondMirrorCol;
                    } else if (officerRow == secondMirrorRow && officerCol == secondMirrorCol) {
                        matrix[officerRow][officerCol] = "-";
                        officerRow = firstMirrorRow;
                        officerCol = firstMirrorCol;
                    }
                } else if (!matrix[officerRow][officerCol].equals("-")) {
                    bladesWorth += Integer.parseInt(matrix[officerRow][officerCol]);
                }

            } else {
                break;
            }
            matrix[officerRow][officerCol] = "-";

        }

        if (bladesWorth < 65) {
            System.out.println("I do not need more swords!");
        } else {
            matrix[officerRow][officerCol] = "A";
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.println("The king paid " + bladesWorth + " gold coins.");
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

    private static boolean validation(String[][] matrix, int officerRow, int officerCol) {
        if (officerRow < 0 || officerRow >= matrix.length || officerCol < 0 || officerCol >= matrix.length) {
            return false;
        }
        return true;
    }
}
