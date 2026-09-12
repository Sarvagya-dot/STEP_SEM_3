import java.util.Arrays;

public class TopThreePodiumFinder {

    public static void main(String[] args) {
        int[] sampleScores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(Arrays.toString(findTopThreeScores(sampleScores)));
    }

    static int[] findTopThreeScores(int[] scores) {
        int firstHighest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        int thirdHighest = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= firstHighest) {
                thirdHighest = secondHighest;
                secondHighest = firstHighest;
                firstHighest = score;
            } else if (score >= secondHighest) {
                thirdHighest = secondHighest;
                secondHighest = score;
            } else if (score > thirdHighest) {
                thirdHighest = score;
            }
        }

        return new int[]{firstHighest, secondHighest, thirdHighest};
    }
}
