package objectsAndClassesLab;
import java.util.Random;
import java.util.Scanner;

public class randomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        String [] words = inputLine.split("\\s+");

        Random generator = new Random();

        for (int i = 0; i < words.length; i++) {
            int indexX = generator.nextInt(words.length);
            int indexY = generator.nextInt(words.length);

            String oldWordX = words[indexX];
            words[indexX] = words[indexY];
            words[indexY] = oldWordX;

        }
        System.out.println(String.join(System.lineSeparator(), words));
    }
}
