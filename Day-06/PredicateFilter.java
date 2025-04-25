package ProblemStatements;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFilter {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("elephant", "cat", "giraffe", "tiger", "dolphin");

        Predicate<String> lengthGreaterThanFive = s -> s.length() > 5;
        Predicate<String> containsA = s -> s.contains("a");

        List<String> filteredWords = words.stream()
                .filter(lengthGreaterThanFive.and(containsA))
                .collect(Collectors.toList());

        System.out.println("Filtered words: " + filteredWords);
    }
}
