import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationQuestionGrader {

    private static final Pattern QUOTED_FIELD_PATTERN = Pattern.compile("\"([^\"]*)\"");

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int questionCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double totalScore = 0;

        for (int questionIndex = 0; questionIndex < questionCount; questionIndex++) {
            String line = userInputScanner.nextLine().trim();

            String questionType = line.substring(0, line.indexOf('"')).trim();
            List<String> quotedFields = new ArrayList<>();
            Matcher matcher = QUOTED_FIELD_PATTERN.matcher(line);

            int lastMatchEnd = 0;
            while (matcher.find()) {
                quotedFields.add(matcher.group(1));
                lastMatchEnd = matcher.end();
            }

            double points = Double.parseDouble(line.substring(lastMatchEnd).trim());
            String correctAnswer = quotedFields.get(1);
            String studentAnswer = quotedFields.get(2);

            Question question = createQuestion(questionType, correctAnswer, studentAnswer, points);
            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", questionType, score);
            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        userInputScanner.close();
    }

    private static Question createQuestion(String questionType, String correctAnswer, String studentAnswer, double points) {
        switch (questionType) {
            case "MCQ":
                return new McqQuestion(correctAnswer, studentAnswer, points);
            case "TF":
                return new TrueFalseQuestion(correctAnswer, studentAnswer, points);
            case "ESSAY":
                return new EssayQuestion(correctAnswer, studentAnswer, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + questionType);
        }
    }
}

abstract class Question {
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String correctAnswer, String studentAnswer, double points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class McqQuestion extends Question {
    McqQuestion(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String correctAnswer, String studentAnswer, double points) {
        super(correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        String lowerCaseStudentAnswer = studentAnswer.toLowerCase();

        int matchedKeywordCount = 0;
        for (String keyword : keywords) {
            if (lowerCaseStudentAnswer.contains(keyword.trim().toLowerCase())) {
                matchedKeywordCount++;
            }
        }

        if (matchedKeywordCount >= 2) {
            return points * 0.75;
        } else if (matchedKeywordCount == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}
