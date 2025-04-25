package ProblemStatements;
@FunctionalInterface
interface SquareCalculator {
    int square(int number);

    default void printSquare(int number) {
        System.out.println("The square of " + number + " is: " + square(number));
    }
}

public class SquareCalculatorDemo {
    public static void main(String[] args) {
        SquareCalculator calculator = (n) -> n * n;
        calculator.printSquare(5);
        calculator.printSquare(10);
    }
}
