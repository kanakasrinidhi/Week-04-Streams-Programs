package ProblemStatements;

import java.util.function.Function;

public class CircleAreaCalculator {
    public static void main(String[] args) {
        Function<Double, Double> calculateArea = radius -> Math.PI * radius * radius;

        double radius = 5.0;
        double area = calculateArea.apply(radius);

        System.out.println("Area of circle: " + area);
    }
}
