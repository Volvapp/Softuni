import java.util.Scanner;

public class Food_Delivery__E7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMenuCount = Integer.parseInt(scanner.nextLine());
        int fishMenuCount = Integer.parseInt(scanner.nextLine());
        int vegetarianMenuCount = Integer.parseInt(scanner.nextLine());

        double chickenMenu = chickenMenuCount * 10.35;
        double fishMenu = fishMenuCount * 12.40;
        double vegetarianMenu = vegetarianMenuCount * 8.15;
        double desert = (chickenMenu + fishMenu + vegetarianMenu) * 0.2;

        double delivery = 2.50;
        double sumNoDelivery = chickenMenu + fishMenu + vegetarianMenu;
        double sumAll = sumNoDelivery + desert + delivery;
        System.out.println(sumAll); 

    }
}
