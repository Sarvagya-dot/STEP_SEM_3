import java.util.Scanner;

public class BankTransactionReferenceValidator {

    private static final int VALID_REFERENCE_LENGTH = 14;
    private static final int BANK_CODE_LENGTH = 3;
    private static final int DATE_LENGTH = 6;

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter raw transaction reference: ");
        String rawReference = userInputScanner.nextLine();

        String normalizedReference = normalizeReference(rawReference);
        System.out.println(validateAndFormat(normalizedReference));

        userInputScanner.close();
    }

    static String normalizeReference(String raw) {
        String trimmedReference = raw.trim();

        if (trimmedReference.length() < BANK_CODE_LENGTH) {
            return trimmedReference.toUpperCase();
        }

        String bankCodePart = trimmedReference.substring(0, BANK_CODE_LENGTH).toUpperCase();
        String remainingPart = trimmedReference.substring(BANK_CODE_LENGTH);

        return bankCodePart + remainingPart;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != VALID_REFERENCE_LENGTH) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, BANK_CODE_LENGTH);
        String datePart = reference.substring(BANK_CODE_LENGTH, BANK_CODE_LENGTH + DATE_LENGTH);
        String sequencePart = reference.substring(BANK_CODE_LENGTH + DATE_LENGTH);

        for (int charIndex = 0; charIndex < bankCode.length(); charIndex++) {
            if (!Character.isLetter(bankCode.charAt(charIndex))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String numericBody = datePart + sequencePart;
        for (int charIndex = 0; charIndex < numericBody.length(); charIndex++) {
            if (!Character.isDigit(numericBody.charAt(charIndex))) {
                return "Invalid: remaining code must be 11 digits";
            }
        }

        String day = datePart.substring(0, 2);
        String month = datePart.substring(2, 4);
        String year = datePart.substring(4, 6);

        StringBuilder formattedLineBuilder = new StringBuilder();
        formattedLineBuilder.append("[").append(bankCode).append("] DATE: ")
                .append(day).append("/").append(month).append("/").append(year)
                .append(" | SEQ: ").append(sequencePart);

        return formattedLineBuilder.toString();
    }
}
