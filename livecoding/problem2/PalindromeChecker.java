import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = userInputScanner.nextLine();

        String iterativeResult = isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome";
        String recursiveResult = isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome";
        String arrayReversalResult = isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome";

        System.out.println("Iterative: " + iterativeResult + " | Recursive: " + recursiveResult
                + " | Array Reversal: " + arrayReversalResult);

        userInputScanner.close();
    }

    static boolean isPalindromeIterative(String text) {
        int leftIndex = 0;
        int rightIndex = text.length() - 1;

        while (leftIndex < rightIndex) {
            if (text.charAt(leftIndex) != text.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursiveHelper(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursiveHelper(String text, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return true;
        }
        if (text.charAt(leftIndex) != text.charAt(rightIndex)) {
            return false;
        }
        return isPalindromeRecursiveHelper(text, leftIndex + 1, rightIndex - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] originalChars = text.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int index = 0; index < originalChars.length; index++) {
            reversedChars[index] = originalChars[originalChars.length - 1 - index];
        }

        return new String(originalChars).equals(new String(reversedChars));
    }
}
