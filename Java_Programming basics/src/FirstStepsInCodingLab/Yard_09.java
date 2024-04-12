import java.util.Scanner;

public class Yard_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
                double km_m = 7.61;
                double otstupka = 0.18;
                double metri = Double.parseDouble(scan.nextLine());
                double cena = metri * km_m;
                double cena2 = cena * otstupka;
                double cena3 = cena - cena2;
        System.out.println("The final price is: " + cena3 + " The discount is: " + cena2 );


    }
}
