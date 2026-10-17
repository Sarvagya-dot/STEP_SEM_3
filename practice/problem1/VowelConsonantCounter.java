import java.util.Scanner;

public class VowelConsonantCounter {

    private static final String VOWELS = "aeiouAEIOU";

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        String word = userInputScanner.nextLine().trim();

        countVowelsAndConsonants(word);

        userInputScanner.close();
    }

    static void countVowelsAndConsonants(String word) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int charIndex = 0; charIndex < word.length(); charIndex++) {
            char currentChar = word.charAt(charIndex);
            if (VOWELS.indexOf(currentChar) != -1) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        System.out.println("Vowels: " + vowelCount);
        System.out.println("Consonants: " + consonantCount);
    }
}
