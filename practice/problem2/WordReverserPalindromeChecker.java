import java.util.Scanner;

public class WordReverserPalindromeChecker {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int wordCount = Integer.parseInt(userInputScanner.nextLine().trim());

        for (int wordIndex = 0; wordIndex < wordCount; wordIndex++) {
            String word = userInputScanner.nextLine().trim();
            String reversedWord = reverseWord(word);
            boolean isPalindrome = word.equalsIgnoreCase(reversedWord);

            System.out.println(reversedWord + " - " + (isPalindrome ? "palindrome" : "not a palindrome"));
        }

        userInputScanner.close();
    }

    static String reverseWord(String word) {
        StringBuilder reversedBuilder = new StringBuilder(word);
        return reversedBuilder.reverse().toString();
    }
}
