
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Question {
    double getScore();
    String getType();
}

class MCQQuestion implements Question {
    private final String correctAnswer;
    private final String studentAnswer;
    private final int points;

    public MCQQuestion(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    @Override
    public double getScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }

    @Override
    public String getType() {
        return "MCQ";
    }
}

class TrueFalseQuestion implements Question {
    private final String correctAnswer;
    private final String studentAnswer;
    private final int points;

    public TrueFalseQuestion(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    @Override
    public double getScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }

    @Override
    public String getType() {
        return "TF";
    }
}

class EssayQuestion implements Question {
    private final String correctAnswer;
    private final String studentAnswer;
    private final int points;

    public EssayQuestion(String correctAnswer, String studentAnswer, int points) {
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    @Override
    public double getScore() {
        String[] keywords = correctAnswer.split(",");
        String studentLower = studentAnswer.toLowerCase();

        int matches = 0;
        for (String keyword : keywords) {
            if (studentLower.contains(keyword.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }

    @Override
    public String getType() {
        return "ESSAY";
    }
}

public class Problem4_ExaminationQuestionGrader {

    private static final Pattern LINE_PATTERN =
            Pattern.compile("^(\\S+)\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+(\\d+)\\s*$");

    static Question createQuestion(String type, String correctAnswer, String studentAnswer, int points) {
        switch (type) {
            case "MCQ":
                return new MCQQuestion(correctAnswer, studentAnswer, points);
            case "TF":
                return new TrueFalseQuestion(correctAnswer, studentAnswer, points);
            case "ESSAY":
                return new EssayQuestion(correctAnswer, studentAnswer, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher m = LINE_PATTERN.matcher(line);
            if (m.matches()) {
                String type = m.group(1);

                String correctAnswer = m.group(3);
                String studentAnswer = m.group(4);
                int points = Integer.parseInt(m.group(5));
                questions.add(createQuestion(type, correctAnswer, studentAnswer, points));
            }
        }

        double total = 0;
        for (Question q : questions) {
            double score = q.getScore();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
