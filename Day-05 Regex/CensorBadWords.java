import java.util.regex.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String sentence = "This is a damn bad example with some stupid words.";
        String[] badWords = { "damn", "stupid" };

        for (String word : badWords) {
            sentence = sentence.replaceAll("(?i)\\b" + Pattern.quote(word) + "\\b", "****");
        }

        System.out.println(sentence);
    }
}
