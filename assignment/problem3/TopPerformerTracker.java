public class TopPerformerTracker {

    public static void main(String[] args) {
        int[] sampleScores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(sampleScores));
    }

    static String findMinMaxSpread(int[] scores) {
        int minimumScore = scores[0];
        int maximumScore = scores[0];

        for (int index = 1; index < scores.length; index++) {
            if (scores[index] < minimumScore) {
                minimumScore = scores[index];
            }
            if (scores[index] > maximumScore) {
                maximumScore = scores[index];
            }
        }

        int spread = maximumScore - minimumScore;
        return "Min: " + minimumScore + " | Max: " + maximumScore + " | Spread: " + spread;
    }
}
