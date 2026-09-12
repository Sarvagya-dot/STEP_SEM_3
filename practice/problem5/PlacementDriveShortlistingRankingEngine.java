import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlacementDriveShortlistingRankingEngine {

    private static final double CGPA_ONLY_THRESHOLD = 7.5;
    private static final double COMBINED_CGPA_THRESHOLD = 6.5;
    private static final int COMBINED_CODING_SCORE_THRESHOLD = 50;

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= CGPA_ONLY_THRESHOLD;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= COMBINED_CGPA_THRESHOLD && codingScore >= COMBINED_CODING_SCORE_THRESHOLD;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlistedCandidates = new ArrayList<>();

        for (Candidate candidate : candidates) {
            if (isEligible(candidate.cgpa) || isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlistedCandidates.add(candidate);
            }
        }

        Candidate[] shortlistedArray = shortlistedCandidates.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder resultBuilder = new StringBuilder();
        for (int index = 0; index < shortlistedArray.length; index++) {
            Candidate candidate = shortlistedArray[index];
            resultBuilder.append(index + 1).append(". ").append(candidate.name);
            resultBuilder.append(" (").append(candidate.compositeScore()).append(")");
            if (index < shortlistedArray.length - 1) {
                resultBuilder.append(" | ");
            }
        }

        return resultBuilder.toString();
    }
}

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    double compositeScore() {
        return (cgpa * 10) + (codingScore * 0.5);
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore(), this.compositeScore());
    }
}
