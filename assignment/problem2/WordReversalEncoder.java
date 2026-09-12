import java.util.Scanner;

public class WordReversalEncoder {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = userInputScanner.nextLine();

        System.out.println(reverseEachWord(sentence));

        userInputScanner.close();
    }

    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder resultBuilder = new StringBuilder();

        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            String reversedWord = new StringBuilder(words[wordIndex]).reverse().toString();
            resultBuilder.append(reversedWord);

            if (wordIndex < words.length - 1) {
                resultBuilder.append(" ");
            }
        }

        return resultBuilder.toString();
    }
}
