import java.util.Scanner;

public class HexColorValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a hex color code: ");
        String colorCode = scanner.nextLine();

        if (isValidHexColor(colorCode)) {
            System.out.println("✅ \"" + colorCode + "\" → Valid");
        } else {
            System.out.println("❌ \"" + colorCode + "\" → Invalid");
        }

        scanner.close();
    }

    public static boolean isValidHexColor(String code) {
        return code.matches("^#([A-Fa-f0-9]{6})$");
    }
}
