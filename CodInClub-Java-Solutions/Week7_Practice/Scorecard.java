/*
 * PRACTICE PROBLEM 2: The Quiz Scorecard
 *
 * Scenario:
 * A quiz app records whether each answer you gave was right or wrong.
 *
 * Problem Statement:
 * Design a Scorecard class that stores each answer's result privately, and
 * reveals only the final score - never the raw list of right/wrong answers.
 *
 * Requirements:
 * - Store the results (true for correct, false for incorrect) in a private
 *   array, filled in one answer at a time.
 * - Provide a method to record the next answer's result.
 * - Expose only the total score (count of correct answers) - never the
 *   array itself, in any form.
 * - The total number of questions must be fixed when the scorecard is
 *   created.
 *
 * Sample:
 *   Scorecard sc = new Scorecard(4);
 *   sc.recordAnswer(true); sc.recordAnswer(true);
 *   sc.recordAnswer(false); sc.recordAnswer(true);
 *   sc.getScore() -> 3
 */
public class Scorecard {

    private final boolean[] results;
    private int answersRecorded;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.answersRecorded = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (answersRecorded < results.length) {
            results[answersRecorded] = isCorrect;
            answersRecorded++;
        }
        // else: fixed question count reached, ignore further recordings
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < answersRecorded; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score after 4 answers (T,T,F,T): " + sc.getScore() + " (expected 3)");

        // Recording beyond the fixed question count is ignored.
        sc.recordAnswer(true);
        System.out.println("Score after trying a 5th answer: " + sc.getScore() + " (still expected 3)");
    }
}
