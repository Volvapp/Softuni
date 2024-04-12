import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();

        while (!destination.equals("End")){
            double neededMoney = Double.parseDouble(scanner.nextLine());
            double savedMoney = 0;
            while (savedMoney < neededMoney){
                double sum = Double.parseDouble(scanner.nextLine());
                savedMoney += sum;
            }
            System.out.printf("Going to %s!%n", destination);


            destination = scanner.nextLine();
        }
    }
}
