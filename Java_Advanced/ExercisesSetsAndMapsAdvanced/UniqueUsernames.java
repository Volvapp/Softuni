package ExercisesSetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();

            set.add(word);
        }
        for (String element : set) {
            System.out.println(element);
        }
    }
}
