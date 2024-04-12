package WorkingWithAbstractionLab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rectanglePoints = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(i -> Integer.parseInt(i))
                .toArray();

        Point bottomLeft = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point topRight = new Point(rectanglePoints[2], rectanglePoints[3]);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Point current = PointUtil.parsePoint(scanner.nextLine());

            System.out.println(rectangle.contains(current));
        }

    }
}
