import java.util.Scanner;

public class Convertor_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double inches = Double.parseDouble(scan.nextLine());
        double cm = inches * 2.54;
        System.out.println(cm);
    }
}
