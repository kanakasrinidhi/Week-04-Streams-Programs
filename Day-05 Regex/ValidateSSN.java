import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String input = "My SSN is 123-45-6789.";

        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println("✅ \"" + matcher.group() + "\" is valid");
        } else {
            System.out.println("❌ No valid SSN found");
        }
    }
}
