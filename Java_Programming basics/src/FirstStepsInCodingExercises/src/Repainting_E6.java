import java.util.Scanner;

public class Repainting_E6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nylonQuantity = Integer.parseInt(scanner.nextLine());

        int paintQuantity = Integer.parseInt(scanner.nextLine());

        int razreditelQuantity = Integer.parseInt(scanner.nextLine());

        int hours = Integer.parseInt(scanner.nextLine());

        double priceAllNylon = (nylonQuantity + 2) * 1.50;

        double priceAllPaint = (paintQuantity *1.10) * 14.50;

        double priceAllRazreditel =razreditelQuantity * 5.0;

        double supplies = priceAllNylon + priceAllPaint + priceAllRazreditel + 0.40;

        double workers = (supplies * 0.30) * hours;

        Double everything = supplies + workers;

        System.out.println(everything);


    }
}
