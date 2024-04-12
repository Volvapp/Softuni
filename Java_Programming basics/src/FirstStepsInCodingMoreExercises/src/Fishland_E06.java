import java.util.Scanner;

public class Fishland_E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double skumriq = Double.parseDouble(scanner.nextLine());
        double caca = Double.parseDouble(scanner.nextLine());
        double palamudKg = Double.parseDouble(scanner.nextLine());
        double safridKg = Double.parseDouble(scanner.nextLine());
        int midiKg = Integer.parseInt(scanner.nextLine());
        double midiCena = 7.50;

        double palamudCena = skumriq + skumriq * 0.60;
        double palamudSum = palamudCena * palamudKg;
        double safridCena = caca + caca * 0.80;
        double safridSum = safridCena * safridKg;
        double midiSum = midiCena * midiKg;
        double sumAll = palamudSum + safridSum + midiSum;

        System.out.printf("%.2f", sumAll);


    }
}
