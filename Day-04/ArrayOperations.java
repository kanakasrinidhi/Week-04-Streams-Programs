package exceptionPracticeProblems;

import java.util.Scanner;

public class ArrayOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Accept the size of the array and the index
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        int[] arr = null;
        
        // Initialize the array based on user input
        try {
            arr = new int[size];
            System.out.println("Enter the elements of the array: ");
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
        } catch (Exception e) {
            System.out.println("Error in array initialization.");
            return;
        }

        // Accept index to retrieve value from the array
        System.out.print("Enter the index to retrieve value: ");
        int index = scanner.nextInt();

        // Perform the array operation and handle exceptions
        try {
            if (arr == null) {
                throw new NullPointerException();
            }
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}
