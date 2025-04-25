public class ValidateCreditCard {
    public static void main(String[] args) {
        String card1 = "4123456789012345"; // Visa
        String card2 = "5123456789012345"; // MasterCard
        String card3 = "6123456789012345"; // Invalid

        System.out.println(validateCard(card1));
        System.out.println(validateCard(card2));
        System.out.println(validateCard(card3));
    }

    public static String validateCard(String cardNumber) {
        String visaRegex = "^4\\d{15}$";
        String masterRegex = "^5\\d{15}$";

        if (cardNumber.matches(visaRegex)) {
            return "Valid Visa card";
        } else if (cardNumber.matches(masterRegex)) {
            return "Valid MasterCard";
        } else {
            return "Invalid card number";
        }
    }
}
