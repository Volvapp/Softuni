package WorkingWithAbstractionLab.PointInRectangle;

public class PointUtil {

    public static Point parsePoint(String input) {
        String[] parts = input.split("\\s+");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        return new Point(x, y);
    }
}
