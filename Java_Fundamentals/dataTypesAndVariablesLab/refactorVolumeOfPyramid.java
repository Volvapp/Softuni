package dataTypesAndVariablesLab;

import java.util.Scanner;

public class refactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length, width, V = 0;

        length = Double.parseDouble(scanner.nextLine());
        System.out.print("Length: ");
        width = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        V = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        V = (length * width * V) / 3;
        System.out.printf("Pyramid Volume: %.2f", V);

    }
}
