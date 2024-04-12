package methodsLab;

import java.util.Scanner;

public class calculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int widthInput = Integer.parseInt(scanner.nextLine());
        int lengthInput = Integer.parseInt(scanner.nextLine());

        System.out.println(calculateArea(widthInput, lengthInput));
    }
    public static int calculateArea(int width, int length) {
        return width * length;
    }
}
