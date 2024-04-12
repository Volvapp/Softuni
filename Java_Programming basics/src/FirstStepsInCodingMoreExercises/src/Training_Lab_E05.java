import java.util.Scanner;

public class Training_Lab_E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double w = Double.parseDouble(scanner.nextLine()) * 100;
        double h = Double.parseDouble(scanner.nextLine()) * 100 - 100;
        double rows = Math.floor(w / 120);
        double columns = Math.floor(h / 70);
        double workPlaces = rows * columns -1 -2;

        System.out.printf("%.2f", workPlaces );
    }
}
