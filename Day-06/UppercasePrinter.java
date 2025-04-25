package ProblemStatements;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class UppercasePrinter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "world", "java", "lambda");

        Consumer<String> toUpper = s -> System.out.println(s.toUpperCase());

        words.forEach(toUpper);
    }
}
