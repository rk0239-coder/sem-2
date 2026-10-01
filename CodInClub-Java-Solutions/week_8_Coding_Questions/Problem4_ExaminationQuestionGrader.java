/*
 * CODING QUESTION 4: Examination Question Grader
 *
 * Task:
 * An examination system evaluates answers for Multiple Choice, True/False,
 * and Essay questions, each with its own grading logic. Process a list of
 * questions with provided answers, score each one, then total the score.
 *
 * Input:
 *   Line 1: integer N (number of questions)
 *   Next N lines: QuestionType "QuestionText" "CorrectAnswer" "StudentAnswer" Points
 *     MCQ "What is 2+2?" "4" "4" 10
 *     TF "Water boils at 100C?" "True" "True" 5
 *     ESSAY "Discuss OOP principles" "Polymorphism, Inheritance, Encapsulation" "I talked about Polymorphism and Inheritance." 20
 *
 * Output:
 *   For each question: "QuestionType: Score" (2 decimals)
 *   Finally: "Total Score: OverallScore" (2 decimals)
 *
 * Business Rules:
 *   - MCQ: full points if StudentAnswer exactly matches CorrectAnswer, else 0.
 *   - TF: full points if StudentAnswer exactly matches CorrectAnswer, else 0.
 *   - ESSAY: CorrectAnswer is a comma-separated list of keywords.
 *       * 2+ keywords found (case-insensitive) in StudentAnswer -> 75% of Points
 *       * exactly 1 keyword found                               -> 50% of Points
 *       * 0 keywords found                                      -> 0 points
 *
 * Sample Input:
 *   4
 *   MCQ "What is the capital of France?" "Paris" "Paris" 10
 *   TF "The Earth is flat?" "False" "True" 5
 *   ESSAY "Name two primary OOP principles." "Inheritance, Polymorphism, Encapsulation" "Polymorphism is one." 20
 *   ESSAY "Describe abstraction and composition." "Abstraction, Composition" "I talked about abstraction." 15
 *
 * Expected Output:
 *   MCQ: 10.00
 *   TF: 0.00
 *   ESSAY: 10.00
 *   ESSAY: 7.50
 *   Total Score: 27.50
 *
 * Design note:
 * Each question type is its own class implementing a common Question
 * interface with getScore(). The grading loop calls getScore()
 * polymorphically, with the grading rule for each question type living
 * entirely inside that question's own class.
 */

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
    private final String correctAnswer; // comma-separated keywords
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

    // Matches: TYPE "questionText" "correctAnswer" "studentAnswer" points
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
                // group(2) is the question text - not needed for scoring
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
