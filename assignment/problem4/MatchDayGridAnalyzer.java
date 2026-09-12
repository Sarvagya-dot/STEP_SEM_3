public class MatchDayGridAnalyzer {

    public static void main(String[] args) {
        int[][] sampleGrid = {
                {4, 6, 8},
                {10, 12, 14},
                {2, 3, 1}
        };
        System.out.println(classifyMatches(sampleGrid, 8));
    }

    private static double rowAverage(int[] row) {
        int rowSum = 0;
        for (int value : row) {
            rowSum += value;
        }
        return (double) rowSum / row.length;
    }

    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int matchIndex = 0; matchIndex < runsPerOver.length; matchIndex++) {
            double average = rowAverage(runsPerOver[matchIndex]);
            String classification = (average >= threshold) ? "Power Surge" : "Normal";

            resultBuilder.append("Match ").append(matchIndex).append(": ").append(classification);
            if (matchIndex < runsPerOver.length - 1) {
                resultBuilder.append(" | ");
            }
        }

        return resultBuilder.toString();
    }
}
