import java.util.Scanner;

public class Weather_Forecast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String weather = scanner.nextLine();
        if (weather.equals("sunny")){
            System.out.println("It's warm outside!");
        }
        else System.out.println("It's cold outside!");
    }
}
