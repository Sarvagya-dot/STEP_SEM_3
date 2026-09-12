import java.util.Scanner;

public class FirstNonRepeatingCharacterFinder {

    private static final int ALPHABET_SIZE = 256;

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = userInputScanner.nextLine();

        try {
            char firstNonRepeatingChar = findFirstNonRepeatingChar(text);
            System.out.println("First Non-Repeating Character: '" + firstNonRepeatingChar + "'");
        } catch (NoNonRepeatingCharacterException noCharException) {
            System.out.println(noCharException.getMessage());
        }

        userInputScanner.close();
    }

    static char findFirstNonRepeatingChar(String text) throws NoNonRepeatingCharacterException {
        int[] characterFrequency = new int[ALPHABET_SIZE];

        for (int charIndex = 0; charIndex < text.length(); charIndex++) {
            characterFrequency[text.charAt(charIndex)]++;
        }

        for (int charIndex = 0; charIndex < text.length(); charIndex++) {
            char currentChar = text.charAt(charIndex);
            if (characterFrequency[currentChar] == 1) {
                return currentChar;
            }
        }

        throw new NoNonRepeatingCharacterException("No Non-Repeating Character Found");
    }
}

class NoNonRepeatingCharacterException extends Exception {
    public NoNonRepeatingCharacterException(String message) {
        super(message);
    }
}
