public class HackathonSeatingGridOptimizer {

    public static void main(String[] args) {
        int[][] sampleGrid = {
                {40, 50, 45},
                {85, 90, 95},
                {30, 20, 25}
        };
        System.out.println(classifyRows(sampleGrid, 60));
    }

    private static double rowAverage(int[] row) {
        int rowSum = 0;
        for (int value : row) {
            rowSum += value;
        }
        return (double) rowSum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder resultBuilder = new StringBuilder();

        for (int rowIndex = 0; rowIndex < seatingScores.length; rowIndex++) {
            double average = rowAverage(seatingScores[rowIndex]);
            String classification = (average < threshold) ? "Quiet Zone" : "Buzzing Zone";

            resultBuilder.append("Row ").append(rowIndex).append(": ").append(classification);
            if (rowIndex < seatingScores.length - 1) {
                resultBuilder.append(" | ");
            }
        }

        return resultBuilder.toString();
    }
}
