package polymorphismLab.shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double radius = Double.parseDouble(scanner.nextLine());

        Shape rectangle = new Rectangle(height, width);
        Shape circle = new Circle(radius);

        System.out.println(rectangle.getArea() + " "
                + rectangle.getPerimeter() + " "
                + circle.getArea() + " "
                + circle.getPerimeter());
    }
}
