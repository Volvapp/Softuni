import java.util.Scanner;

public class Zooshop_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double dog = 2.50;
        int cat = 4;
        System.out.println("broi opakovko kucheshka hrana: ");
        int dog_packages = Integer.parseInt(scan.nextLine());
        int cat_packages = Integer.parseInt(scan.nextLine());
        System.out.println((dog * dog_packages) + (cat * cat_packages) + " lv.");


    }
}
