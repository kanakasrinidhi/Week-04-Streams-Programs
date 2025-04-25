import java.util.regex.*;
import java.util.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        Pattern pattern = Pattern.compile("\\b(\\w+)\\b\\s+\\1\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> repeatingWords = new LinkedHashSet<>();

        while (matcher.find()) {
            repeatingWords.add(matcher.group(1).toLowerCase());
        }

        for (String word : repeatingWords) {
            System.out.println(word);
        }
    }
}

