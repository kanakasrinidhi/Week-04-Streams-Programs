package Exceptions;

public class DivisionHandler {

    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            int result = calculate(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error during division: " + e.getMessage());
        }
    }

    public static int performDivision(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return numerator / denominator;
    }

    public static int calculate(int numerator, int denominator) {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Division failed for inputs (" + numerator + ", " + denominator + "): " + e.getMessage());
        }
    }
}
