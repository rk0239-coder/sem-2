import java.util.Arrays;
public class P1_HackathonScoreCurveBooster {
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
}
public static void main(String[] args) {
    int[] scores = {70, 85, 60};
    curveScores(scores, 10);
    System.out.println("Output: " + Arrays.toString(scores));
    System.out.println("Expected: [80, 95, 70]");
}
}
