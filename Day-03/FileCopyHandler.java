package Javastreams;
import java.io.*;

public class FileCopyHandler {
    public static void main(String[] args) {
        String sourceFile = "source.txt"; // Change as needed
        String destinationFile = "destination.txt"; // Output file

        try {
            File inputFile = new File(sourceFile);

            if (!inputFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(destinationFile);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            fis.close();
            fos.close();

            System.out.println("File copied successfully to: " + destinationFile);
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file: " + e.getMessage());
        }
    }
}
