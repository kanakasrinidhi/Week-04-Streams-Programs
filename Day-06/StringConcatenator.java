package ProblemStatements;

import java.util.function.BiFunction;

public class StringConcatenator {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + " " + s2;

        String result = concatenate.apply("Hello", "World");

        System.out.println(result);
    }
}
