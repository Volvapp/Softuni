package LabStreamsFilesAndDirectories;

import com.sun.tools.attach.VirtualMachineDescriptor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        String basePath = "C:\\Users\\user\\Desktop\\coding\\Exercises #3\\01._Read File_Ресурси\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\04_output.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPath));
        PrintStream writer = System.out; // new PrintStream(new FileOutputStream(outputPath)); -> prints in 04_output file


        while (reader.hasNext()) {
            if (reader.hasNextInt()){
                writer.println(reader.nextInt());
            }
            reader.next();
        }
    }
}
