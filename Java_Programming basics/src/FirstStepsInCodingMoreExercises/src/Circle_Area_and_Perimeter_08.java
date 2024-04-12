import java.util.Scanner;

public class Circle_Area_and_Perimeter_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        double S = r * r * Math.PI;
        System.out.printf("%.2f\n", S);

        double diameter = 2 * r;
        double perimeter = diameter * Math.PI;
        System.out.printf("%.2f", perimeter);
    }
}
