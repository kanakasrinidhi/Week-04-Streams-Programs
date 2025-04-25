package ProblemStatements;
import java.util.*;
import java.util.stream.*;

public class FilterStrings {
    public static void main(String[] args) {

        List<String> strings = Arrays.asList("Apple", "Banana", "Avocado", "Orange", "Apricot", "Grape");


        List<String> filteredStrings = strings.stream()
                .filter(s -> !s.startsWith("A"))
                .collect(Collectors.toList());


        System.out.println("Strings that don't start with 'A': " + filteredStrings);
    }
}
