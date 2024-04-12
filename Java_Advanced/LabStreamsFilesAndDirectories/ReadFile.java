package LabStreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String filePath = "C:\\Users\\user\\Desktop\\coding\\Exercises #3\\01._Read File_Ресурси\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (InputStream inputStream = new FileInputStream(filePath)) {

            int readByte = inputStream.read();

            while (readByte >= 0) {

                System.out.print(Integer.toBinaryString(readByte) + " ");

                readByte = inputStream.read();
            }

        } catch (IOException e) {

            throw new RuntimeException(e);
        }


//        InputStream inputStream = new FileInputStream(filePath);
//
//        int firstByte = inputStream.read();
//
//        System.out.println(firstByte);
//
//        inputStream.close();
    }
}
