import java.util.regex.*;
import java.util.*;

public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Define regex pattern to match capitalized words commonly used as programming languages
        Pattern pattern = Pattern.compile("\\b(JavaScript|Python|Java|Go|C\\+\\+|C#|Ruby|Kotlin|Swift|Rust|PHP)\\b");
        Matcher matcher = pattern.matcher(text);

        List<String> languages = new ArrayList<>();

        while (matcher.find()) {
            languages.add(matcher.group());
        }

        System.out.println(String.join(", ", languages));
    }
}
