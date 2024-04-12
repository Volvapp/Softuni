import java.util.Scanner;

public class Fish_Tank_E9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percentage = Double.parseDouble(scanner.nextLine());

        double percent = 0.001;

        double v = length * width * height;
        double vInLiters = v * percent;
        double percIntoValue = percentage / 100;
        double neededLiters = vInLiters * (1 - percIntoValue);
        System.out.println(neededLiters);

    }
}
