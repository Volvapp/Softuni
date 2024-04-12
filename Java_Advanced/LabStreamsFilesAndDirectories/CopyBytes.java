package LabStreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String basePath = "C:\\Users\\user\\Desktop\\coding\\Exercises #3\\01._Read File_Ресурси\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\03_output.txt";


        try (InputStream inputStream = new FileInputStream(inputPath);
             OutputStream outputStream = new FileOutputStream(outputPath)) {

            int readByte = inputStream.read();

            while (readByte >= 0) {

                if (readByte == 10 || readByte == 32) { // ' ' => 10 // '\n' => 32 - ascii codes
                    outputStream.write(readByte);
                } else {
                    String number = String.valueOf(readByte);
                    for (int i = 0; i < number.length(); i++) {
                        outputStream.write(number.charAt(i));
                    }

                }


                readByte = inputStream.read();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
