import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username to validate: ");
        String username = scanner.nextLine();

        if (isValidUsername(username)) {
            System.out.println("✅ \"" + username + "\" → Valid");
        } else {
            System.out.println("❌ \"" + username + "\" → Invalid");
        }

        scanner.close();
    }

    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }
}
