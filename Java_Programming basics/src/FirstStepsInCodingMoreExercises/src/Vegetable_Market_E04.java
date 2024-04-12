import java.util.Scanner;

public class Vegetable_Market_E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());
        double m = Double.parseDouble(scanner.nextLine());
        int nAll = Integer.parseInt(scanner.nextLine());
        int mAll = Integer.parseInt(scanner.nextLine());
        double euro = 1.94;

        double vegetables = n  * nAll;
        double fruits = m  * mAll;
        double all = vegetables + fruits;
        double inEuro = all / euro;

        System.out.printf("%.2f", inEuro);
    }
}
