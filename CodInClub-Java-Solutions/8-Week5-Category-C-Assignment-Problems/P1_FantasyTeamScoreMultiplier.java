import java.util.Arrays;
public class P1_FantasyTeamScoreMultiplier {
    static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }
public static void main(String[] args) {
    double[] scores = {40, 55, 30, 62};
    applyMultipliers(scores, 1, 3);
    System.out.println("Output: " + Arrays.toString(scores));
    System.out.println("Expected: [40.0, 110.0, 30.0, 93.0]");
}
}
