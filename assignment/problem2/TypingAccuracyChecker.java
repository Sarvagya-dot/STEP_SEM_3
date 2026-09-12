import java.util.Scanner;

public class TypingAccuracyChecker {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        System.out.print("Enter the original passage: ");
        String originalPassage = userInputScanner.nextLine();

        System.out.print("Enter the typed passage: ");
        String typedPassage = userInputScanner.nextLine();

        try {
            checkTypingAccuracy(originalPassage, typedPassage);
        } catch (UnequalLengthException lengthException) {
            System.out.println("Error: " + lengthException.getMessage());
        }

        userInputScanner.close();
    }

    private static void checkTypingAccuracy(String original, String typed) throws UnequalLengthException {
        if (original.length() != typed.length()) {
            throw new UnequalLengthException("Original and typed text must be of equal length.");
        }

        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        for (int charIndex = 0; charIndex < totalCharacters; charIndex++) {
            char originalChar = original.charAt(charIndex);
            char typedChar = typed.charAt(charIndex);

            if (originalChar == typedChar) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = charIndex + 1;
            }
        }

        double accuracyPercentage = ((double) matchedCharacters / totalCharacters) * 100;
        printAccuracyReport(original, typed, matchedCharacters, totalCharacters, accuracyPercentage, firstMismatchPosition);
    }

    private static void printAccuracyReport(String original, String typed, int matchedCharacters,
            int totalCharacters, double accuracyPercentage, int firstMismatchPosition) {

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Matched: ").append(matchedCharacters).append("/").append(totalCharacters);
        resultBuilder.append(" | Accuracy: ").append(String.format("%.2f", accuracyPercentage)).append("%");

        if (firstMismatchPosition == -1) {
            resultBuilder.append(" | No Mismatches");
        } else {
            char originalCharAtMismatch = original.charAt(firstMismatchPosition - 1);
            char typedCharAtMismatch = typed.charAt(firstMismatchPosition - 1);
            resultBuilder.append(" | First Mismatch at position ").append(firstMismatchPosition);
            resultBuilder.append(" (\'").append(originalCharAtMismatch).append("\' vs \'")
                    .append(typedCharAtMismatch).append("\')");
        }

        System.out.println(resultBuilder.toString());
    }
}

class UnequalLengthException extends Exception {
    public UnequalLengthException(String message) {
        super(message);
    }
}
