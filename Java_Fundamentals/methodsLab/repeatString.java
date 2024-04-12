package methodsLab;

import java.util.Scanner;

public class repeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatingString(n, inputText));
    }

    public static String repeatingString(int n, String text) {
        String result = "";
        for (int i = 1; i <= n; i++) {
            result += text;
        }
        return result;
    }
}
