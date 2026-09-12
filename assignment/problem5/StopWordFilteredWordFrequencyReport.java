import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StopWordFilteredWordFrequencyReport {

    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter feedback text: ");
        String feedback = userInputScanner.nextLine();

        printFilteredWordFrequency(feedback);

        userInputScanner.close();
    }

    static void printFilteredWordFrequency(String feedback) {
        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleanedText.split("\\s+");

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> frequencyEntries = new ArrayList<>(wordFrequency.entrySet());
        frequencyEntries.sort((firstEntry, secondEntry) -> secondEntry.getValue() - firstEntry.getValue());

        for (Map.Entry<String, Integer> entry : frequencyEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static boolean isStopWord(String word) {
        for (String stopWord : STOP_WORDS) {
            if (stopWord.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
