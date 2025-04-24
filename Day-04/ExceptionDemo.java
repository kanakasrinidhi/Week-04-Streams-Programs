package Exceptions;

import java.io.IOException;

public class ExceptionDemo {

    public static void processData(String input) throws IOException {
        if (input == null) {
            throw new NullPointerException("Input is null"); // unchecked exception
        }

        if (input.isEmpty()) {
            throw new IOException("Input is empty"); // checked exception
        }

        System.out.println("Processing data: " + input);
    }

    public static void main(String[] args) {
        try {
            processData(null);
        } catch (IOException e) {
            System.out.println("Checked Exception: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Unchecked Exception: " + e.getMessage());
        }
    }
}
