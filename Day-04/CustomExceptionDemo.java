package exceptionPracticeProblems;

import java.util.Scanner;

//Custom exception class
class InvalidAgeException extends Exception {
 public InvalidAgeException(String message) {
     super(message);
 }
}

public class CustomExceptionDemo {

 // Method to validate age
 public static void validateAge(int age) throws InvalidAgeException {
     if (age < 18) {
         throw new InvalidAgeException("Age must be 18 or above");
     }
 }

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Taking user input for age
     System.out.print("Enter your age: ");
     int age = scanner.nextInt();

     try {
         // Validate the age
         validateAge(age);
         System.out.println("Access granted!");
     } catch (InvalidAgeException e) {
         System.out.println(e.getMessage());  // Print custom exception message
     } finally {
         scanner.close();
     }
 }
}
