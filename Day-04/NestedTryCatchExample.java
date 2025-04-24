
package exceptionPracticeProblems;
import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.print("Enter array index to access: ");
        int index = scanner.nextInt();

        System.out.print("Enter a divisor: ");
        int divisor = scanner.nextInt();

        try {
            int value = numbers[index];
            try {
                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }
}
