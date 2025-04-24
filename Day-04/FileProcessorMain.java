package Exceptions;

import java.io.*;
import java.util.*;

public class FileProcessorMain {
    public static void main(String[] args) {
        List<String> filePaths = Arrays.asList("file1.txt", "file2.txt");

        createSampleFile("file1.txt", "Hello from file one.\nLine 2 from file one.");
        createSampleFile("file2.txt", "Greetings from file two.\nAnother line here.");

        for (String path : filePaths) {
            try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String line;
                System.out.println("Reading file: " + path);
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println();
            } catch (IOException e) {
                System.out.println("Error reading file: " + path);
                System.out.println(e.getMessage());
            }
        }
    }

    public static void createSampleFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("Error creating file: " + fileName);
            System.out.println(e.getMessage());
        }
    }
}
