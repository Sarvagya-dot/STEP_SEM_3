import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    private static final int REQUIRED_PHONE_LENGTH = 10;

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter phone number: ");
        String phone = userInputScanner.nextLine();

        System.out.println(maskPhoneNumber(phone));

        userInputScanner.close();
    }

    static String maskPhoneNumber(String phone) {
        if (!isValidPhoneNumber(phone)) {
            return "Invalid phone number";
        }

        String lastFourDigits = phone.substring(phone.length() - 4);

        StringBuilder maskedNumberBuilder = new StringBuilder();
        maskedNumberBuilder.append("XXXXXX");
        maskedNumberBuilder.append("-");
        maskedNumberBuilder.append(lastFourDigits);

        return maskedNumberBuilder.toString();
    }

    private static boolean isValidPhoneNumber(String phone) {
        if (phone.length() != REQUIRED_PHONE_LENGTH) {
            return false;
        }

        for (int charIndex = 0; charIndex < phone.length(); charIndex++) {
            if (!Character.isDigit(phone.charAt(charIndex))) {
                return false;
            }
        }

        return true;
    }
}
