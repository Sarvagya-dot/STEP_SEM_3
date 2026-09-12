import java.util.Scanner;

public class LibraryISBNNormalizerValidator {

    private static final int VALID_CODE_LENGTH = 13;
    private static final int PUBLISHER_CODE_LENGTH = 3;
    private static final int YEAR_LENGTH = 4;

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter raw ISBN-style code: ");
        String rawCode = userInputScanner.nextLine();

        String normalizedCode = normalizeCode(rawCode);
        System.out.println(validateAndFormat(normalizedCode));

        userInputScanner.close();
    }

    static String normalizeCode(String raw) {
        String trimmedCode = raw.trim();

        if (trimmedCode.length() < PUBLISHER_CODE_LENGTH) {
            return trimmedCode.toUpperCase();
        }

        String publisherPart = trimmedCode.substring(0, PUBLISHER_CODE_LENGTH).toUpperCase();
        String remainingPart = trimmedCode.substring(PUBLISHER_CODE_LENGTH);

        return publisherPart + remainingPart;
    }

    static String validateAndFormat(String code) {
        if (code.length() != VALID_CODE_LENGTH) {
            return "Invalid: code must be exactly 13 characters";
        }

        String publisherCode = code.substring(0, PUBLISHER_CODE_LENGTH);
        String yearPart = code.substring(PUBLISHER_CODE_LENGTH, PUBLISHER_CODE_LENGTH + YEAR_LENGTH);
        String catalogPart = code.substring(PUBLISHER_CODE_LENGTH + YEAR_LENGTH);

        for (int charIndex = 0; charIndex < publisherCode.length(); charIndex++) {
            if (!Character.isLetter(publisherCode.charAt(charIndex))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        String numericBody = yearPart + catalogPart;
        for (int charIndex = 0; charIndex < numericBody.length(); charIndex++) {
            if (!Character.isDigit(numericBody.charAt(charIndex))) {
                return "Invalid: remaining code must be 10 digits";
            }
        }

        StringBuilder formattedLineBuilder = new StringBuilder();
        formattedLineBuilder.append("[").append(publisherCode).append("] YEAR: ").append(yearPart);
        formattedLineBuilder.append(" | CATALOG: ").append(catalogPart);

        return formattedLineBuilder.toString();
    }
}
