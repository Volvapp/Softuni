import java.util.Scanner;

public class House_Painting_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        //Walls
        double sideWall = x * y;
        double window = 1.5 * 1.5;
        double bothWalls = 2 * sideWall - 2 * window;
        double backWall = x * x;
        double entrance = 1.2 * 2;
        double frontAndBack = 2 * backWall - entrance;
        double wholeSpace = bothWalls + frontAndBack;
        double greenPaint = wholeSpace / 3.4;
        System.out.printf("%.2f\n", greenPaint);

        //Roof
        double roofRectangles = 2 * (x * y);
        double bothTriangles = 2 * (x * h /2);
        double wholeSpace2 = roofRectangles + bothTriangles;
        double redPaint = wholeSpace2 / 4.3;
        System.out.printf("%.2f", redPaint);
    }
}
