package ExercisesStreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String filePth = "C:\\Users\\user\\Desktop\\coding\\Exercises #3\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        List<String> allLines = Files.readAllLines(Path.of(filePth));

        long sum = 0;

        for (String line : allLines) {

            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }
        System.out.println(sum);
    }
}
