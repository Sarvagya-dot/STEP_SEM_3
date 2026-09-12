import java.util.Scanner;

public class VowelConsonantCounter {

    private static final String VOWELS = "aeiouAEIOU";

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = userInputScanner.nextLine();

        countVowelsAndConsonants(text);

        userInputScanner.close();
    }

    static void countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int charIndex = 0; charIndex < text.length(); charIndex++) {
            char currentChar = text.charAt(charIndex);

            if (currentChar == ' ') {
                continue;
            }

            if (VOWELS.indexOf(currentChar) != -1) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        System.out.println("Vowels: " + vowelCount + " | Consonants: " + consonantCount);
    }
}
