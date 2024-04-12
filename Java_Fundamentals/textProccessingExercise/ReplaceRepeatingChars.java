package textProccessingExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("");

        String lastSymbol = "";
        for (int i = 0; i <= input.length - 1; i++) {
            String currentSymbol = input[i];
            if (i == input.length - 1){
                System.out.println(currentSymbol);
                break;
            }
            if (currentSymbol.equals(input[i + 1])) {
            }else {
                System.out.print(currentSymbol);
            }
        }
    }
}
