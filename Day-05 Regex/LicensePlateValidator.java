import java.util.Scanner;

public class LicensePlateValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a license plate number: ");
        String plate = scanner.nextLine();

        if (isValidPlate(plate)) {
            System.out.println("✅ \"" + plate + "\" → Valid");
        } else {
            System.out.println("❌ \"" + plate + "\" → Invalid");
        }

        scanner.close();
    }

    public static boolean isValidPlate(String plate) {
        return plate.matches("^[A-Z]{2}[0-9]{4}$");
    }
}
