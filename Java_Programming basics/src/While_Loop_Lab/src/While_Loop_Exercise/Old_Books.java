package While_Loop_Exercise;

import java.util.Scanner;

public class Old_Books {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wantedBook = scanner.nextLine();
        String command = scanner.nextLine();
        int counter = 0;
        boolean wasFound = false;
        while (!command.equals("No More Books")) {
            String currentBook = command;

            if (currentBook.equals(wantedBook)) {
                wasFound = true;
                break;
            }
            counter++;
            command = scanner.nextLine();
        }
        if (wasFound) {
            System.out.printf("You checked %d books and found it.", counter);
        } else {
            System.out.printf("The book you search is not here!%nYou checked %d books.",
                    counter);
        }
    }
}
