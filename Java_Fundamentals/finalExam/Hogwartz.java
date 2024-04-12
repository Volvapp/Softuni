package finalExam;

import java.util.Scanner;

public class Hogwartz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder spellSb = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Abracadabra")) {

            String[] commands = input.split(" ");

            if (commands[0].equals("Abjuration")) {
                spellSb = new StringBuilder(spellSb.toString().toUpperCase());
                System.out.println(spellSb);


            } else if (commands[0].equals("Necromancy")) {
                spellSb = new StringBuilder(spellSb.toString().toLowerCase());
                System.out.println(spellSb);


            } else if (commands[0].equals("Illusion")) {
                int index = Integer.parseInt(commands[1]);
                String letter = commands[2];
                if (index < 0 || index >= spellSb.length()) {
                    System.out.println("The spell was too weak.");
                } else {
                    spellSb.setCharAt(index, letter.charAt(0));
                    System.out.println("Done!");
                }


            } else if (commands[0].equals("Divination")) {
                String firstSubstring = commands[1];
                String replacement = commands[2];

                if (spellSb.toString().contains(firstSubstring)) {
                    spellSb = new StringBuilder(spellSb.toString().replace(firstSubstring, replacement));
                    System.out.println(spellSb);
                }


            } else if (commands[0].equals("Alteration")) {
                String substring = commands[1];
                if (spellSb.toString().contains(substring)) {

                    spellSb = new StringBuilder(spellSb.toString().replace(substring, ""));
                    System.out.println(spellSb);
                }

            } else {
                System.out.println("The spell did not work!");
            }

            input = scanner.nextLine();
        }
    }
}
