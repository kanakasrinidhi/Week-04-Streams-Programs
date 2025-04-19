import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        Map<Integer, List<String>> invertedMap = invertMap(originalMap);
        System.out.println(invertedMap);
    }

    public static Map<Integer, List<String>> invertMap(Map<String, Integer> map) {
        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            invertedMap.putIfAbsent(entry.getValue(), new ArrayList<>());
            invertedMap.get(entry.getValue()).add(entry.getKey());
        }

        return invertedMap;
    }
}
