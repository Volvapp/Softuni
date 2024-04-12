package textProccessingExercise;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder textBuilder = new StringBuilder(input);
        int totalPower = 0;
        for (int position = 0; position <= textBuilder.length() - 1; position++) {
            char currentSymbol = textBuilder.charAt(position);

            if (currentSymbol == '>'){
                int power = Integer.parseInt(textBuilder.charAt(position + 1) + "");
                totalPower += power;

            }else if (currentSymbol != '>' && totalPower > 0){
                textBuilder.deleteCharAt(position);
                totalPower--;
                position--;
            }
        }
        System.out.println(textBuilder);
    }
}
