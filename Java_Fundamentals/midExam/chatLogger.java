package midExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class chatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        List<String> chatList = new ArrayList<>();
        while (!inputLine.equals("end")){
            String [] commands = inputLine.split(" ");

            switch (commands[0]){
                case "Chat":
                    chatList.add(commands[1]);
                    break;
                case "Delete":
                    chatList.remove(commands[1]);
                    break;
                case "Edit":
                    if (chatList.contains(commands[1])){
                        int index = chatList.indexOf(commands[1]);
                        chatList.set(index, commands[2]);
                    }
                    break;
                case "Pin":
                    if (chatList.contains(commands[1])){
                        String word = commands[1];
                        chatList.remove(commands[1]);
                        chatList.add(word);
                    }

                    break;
                case "Spam":
                    for (int i = 1; i <= commands.length - 1; i++) {
                        chatList.add(commands[i]);
                    }
                    break;
            }
            inputLine = scanner.nextLine();
        }
        for (int i = 0; i <= chatList.size() - 1; i++) {
            String currentElement = chatList.get(i);
            System.out.println(currentElement);
        }
    }
}
