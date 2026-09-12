import java.util.Scanner;

public class ATMPinLengthValidator {

    private static final int REQUIRED_PIN_LENGTH = 4;

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        String pin = userInputScanner.nextLine();

        checkPinLength(pin);

        userInputScanner.close();
    }

    static void checkPinLength(String pin) {
        int pinLength = pin.length();

        if (pinLength != REQUIRED_PIN_LENGTH) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
}
