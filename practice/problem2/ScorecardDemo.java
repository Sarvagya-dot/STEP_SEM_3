public class ScorecardDemo {

    public static void main(String[] args) {
        Scorecard scorecard = new Scorecard(4);

        scorecard.recordAnswer(true);
        scorecard.recordAnswer(true);
        scorecard.recordAnswer(false);
        scorecard.recordAnswer(true);

        System.out.println("Score: " + scorecard.getScore());
    }
}

class Scorecard {
    private boolean[] results;
    private int totalQuestions;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < totalQuestions) {
            results[recordedCount] = isCorrect;
            recordedCount++;
        }
    }

    public int getScore() {
        int correctCount = 0;
        for (int index = 0; index < recordedCount; index++) {
            if (results[index]) {
                correctCount++;
            }
        }
        return correctCount;
    }
}
