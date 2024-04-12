import java.util.Scanner;

public class USD_to_BGN_E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double usd = Double.parseDouble(scanner.nextLine());
        double BGN = usd * 1.79549;
        System.out.println(BGN);

    }
}
