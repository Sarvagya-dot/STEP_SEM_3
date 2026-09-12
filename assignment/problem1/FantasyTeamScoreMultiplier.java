import java.util.Arrays;

public class FantasyTeamScoreMultiplier {

    private static final double CAPTAIN_MULTIPLIER = 2.0;
    private static final double VICE_CAPTAIN_MULTIPLIER = 1.5;

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        applyMultipliers(scores, 1, 3);
        System.out.println(Arrays.toString(scores));
    }

    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] = playerScores[captainIndex] * CAPTAIN_MULTIPLIER;
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * VICE_CAPTAIN_MULTIPLIER;
    }
}
