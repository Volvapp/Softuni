package textProccessingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        List<String> words = Arrays.stream(scanner.nextLine().split("\\\\")).collect(Collectors.toList());
//
//        String[] lastWords = words.get(words.size() - 1).split("\\.");
//        String firstWord = lastWords[0];
//        String secondWord = lastWords[1];
//
//        System.out.println("File name: " + firstWord);
//        System.out.println("File extension: " + secondWord);

        String path = scanner.nextLine();
        String[] pathParts = path.split("\\\\");
        String fullFileName = pathParts[pathParts.length - 1];
        String fileName = fullFileName.split("\\.")[0];
        String extension = fullFileName.split("\\.")[1];
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
