import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    private static final String VALID_SIGNAL_COLORS = "RYG";

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);

        System.out.print("Enter the signal log (letters R, Y, G only): ");
        String signalLog = userInputScanner.nextLine();

        try {
            findLongestStreak(signalLog);
        } catch (IllegalArgumentException invalidSignalException) {
            System.out.println("Error: " + invalidSignalException.getMessage());
        }

        userInputScanner.close();
    }

    private static void findLongestStreak(String signalLog) {
        validateSignalLog(signalLog);

        char longestStreakColor = signalLog.charAt(0);
        int longestStreakLength = 1;

        char currentStreakColor = signalLog.charAt(0);
        int currentStreakLength = 1;

        for (int charIndex = 1; charIndex < signalLog.length(); charIndex++) {
            char currentChar = signalLog.charAt(charIndex);

            if (currentChar == currentStreakColor) {
                currentStreakLength++;
            } else {
                currentStreakColor = currentChar;
                currentStreakLength = 1;
            }

            if (currentStreakLength > longestStreakLength) {
                longestStreakLength = currentStreakLength;
                longestStreakColor = currentStreakColor;
            }
        }

        int asciiCodeOfStreakColor = (int) longestStreakColor;

        System.out.println("Longest Streak: \'" + longestStreakColor + "\' repeated " + longestStreakLength + " times");
        System.out.println("ASCII Code of Streak Color: " + asciiCodeOfStreakColor);
    }

    private static void validateSignalLog(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            throw new IllegalArgumentException("Signal log cannot be empty.");
        }

        for (int charIndex = 0; charIndex < signalLog.length(); charIndex++) {
            char currentChar = signalLog.charAt(charIndex);
            if (VALID_SIGNAL_COLORS.indexOf(currentChar) == -1) {
                throw new IllegalArgumentException("Invalid signal character found: " + currentChar);
            }
        }
    }
}
