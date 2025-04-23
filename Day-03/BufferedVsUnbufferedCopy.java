package Javastreams;
import java.io.*;

public class BufferedVsUnbufferedCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.txt"; // Use a file around 100MB
        String unbufferedTarget = "unbuffered_copy.txt";
        String bufferedTarget = "buffered_copy.txt";

        // Copy using unbuffered streams
        long startUnbuffered = System.nanoTime();
        copyUsingUnbuffered(sourceFile, unbufferedTarget);
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered Copy Time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");

        // Copy using buffered streams
        long startBuffered = System.nanoTime();
        copyUsingBuffered(sourceFile, bufferedTarget);
        long endBuffered = System.nanoTime();
        System.out.println("Buffered Copy Time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");
    }

    // Unbuffered copy (FileInputStream/FileOutputStream)
    private static void copyUsingUnbuffered(String source, String destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[4096]; // 4 KB chunk
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Unbuffered copy error: " + e.getMessage());
        }
    }

    // Buffered copy (BufferedInputStream/BufferedOutputStream)
    private static void copyUsingBuffered(String source, String destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096]; // 4 KB chunk
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Buffered copy error: " + e.getMessage());
        }
    }
}
