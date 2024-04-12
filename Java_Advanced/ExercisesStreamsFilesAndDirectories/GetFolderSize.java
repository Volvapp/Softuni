package ExercisesStreamsFilesAndDirectories;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\user\\Desktop\\coding\\Exercises #3\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);

        File[] allFilesInFolder = folder.listFiles();

        int folderSize = 0;

        for (int i = 0; i < allFilesInFolder.length; i++) {
            folderSize += allFilesInFolder[i].length();
        }
        System.out.println("Folder size: " + folderSize);
    }
}
