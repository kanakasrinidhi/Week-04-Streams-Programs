package ProblemStatements;
import java.util.*;

public class OptionalMaxValue {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 10, 20, 3, 8);

        Optional<Integer> max = numbers.stream().max(Integer::compareTo);

        if (max.isPresent()) {
            System.out.println("Maximum value is: " + max.get());
        } else {
            System.out.println("List is empty. No maximum value found.");
        }

        List<Integer> emptyList = new ArrayList<>();
        Optional<Integer> emptyMax = emptyList.stream().max(Integer::compareTo);

        int result = emptyMax.orElse(-1);
        System.out.println("Maximum value in empty list (with default): " + result);
    }
}
