package ExercisesStreamsFilesAndDirectories;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordsCount {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\user\\Desktop\\coding\\Exercises #3\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\words.txt";
        List<String> allLinesWithWords = Files.readAllLines(Path.of(path));
        Map<String, Integer> countWords = new HashMap<>();

        for (String line : allLinesWithWords) {
            String[] wordsOnCurrentRow = line.split("\\s+");
            Arrays.stream(wordsOnCurrentRow).forEach(word -> {
                countWords.put(word, 0);
            });
        }
        String text = "C:\\Users\\user\\Desktop\\coding\\Exercises #3\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\text.txt";

        List<String> allLinesWithText = Files.readAllLines(Path.of(text));
        for (String line : allLinesWithText) {
            String[] wordsPerLine = line.split("\\s+");

            for (String word : wordsPerLine) {
                if (countWords.containsKey(word)) {
                    countWords.put(word, countWords.get(word) + 1);
                }
            }
        }
        PrintWriter writer = new PrintWriter("C:\\Users\\user\\Desktop\\coding\\Exercises #3\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources\\result.txt");
        countWords.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}
