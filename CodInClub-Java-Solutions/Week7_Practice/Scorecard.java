
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

        sc.recordAnswer(true);
        System.out.println("Score after trying a 5th answer: " + sc.getScore() + " (still expected 3)");
    }
}
