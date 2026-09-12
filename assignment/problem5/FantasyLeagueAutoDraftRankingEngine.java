import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FantasyLeagueAutoDraftRankingEngine {

    private static final int EXPERIENCE_ONLY_MATCH_THRESHOLD = 10;
    private static final int COMBINED_MATCH_THRESHOLD = 5;

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= EXPERIENCE_ONLY_MATCH_THRESHOLD;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= COMBINED_MATCH_THRESHOLD && !injured;
    }

    static String draftAndRank(Player[] players) {
        List<Player> draftablePlayers = new ArrayList<>();

        for (Player player : players) {
            if (isDraftable(player.matchesPlayed) || isDraftable(player.matchesPlayed, player.injured)) {
                draftablePlayers.add(player);
            }
        }

        Player[] draftableArray = draftablePlayers.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder resultBuilder = new StringBuilder();
        for (int index = 0; index < draftableArray.length; index++) {
            resultBuilder.append(index + 1).append(". ").append(draftableArray[index].name);
            if (index < draftableArray.length - 1) {
                resultBuilder.append(" | ");
            }
        }

        return resultBuilder.toString();
    }
}

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}
