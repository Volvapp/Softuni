import java.util.Scanner;

public class Sequence_2k1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       int n = Integer.parseInt(scanner.nextLine());
//
//        for (int number = 1; number <= n; number = number * 2 + 1) {
//            System.out.println(number);
//        }

        int number = 1;
        while (n >= number){
            System.out.println(number);
            number = number * 2 + 1;
        }
    }
}