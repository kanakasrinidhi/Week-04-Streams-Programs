import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : items) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }
        System.out.println(frequencyMap);
    }
}
