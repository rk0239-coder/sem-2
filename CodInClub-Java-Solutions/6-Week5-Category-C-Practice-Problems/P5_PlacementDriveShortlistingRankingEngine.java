import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class P5_PlacementDriveShortlistingRankingEngine {
    static final double CGPA_ONLY_THRESHOLD = 7.5;
    static final double COMBINED_CGPA_THRESHOLD = 6.5;
    static final int COMBINED_CODING_SCORE_THRESHOLD = 50;
    static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;
        Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }
    double compositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }
@Override
public int compareTo(Candidate other) {
    return Double.compare(other.compositeScore(), this.compositeScore());
}
}
static boolean isEligible(double cgpa) {
    return cgpa >= CGPA_ONLY_THRESHOLD;
}
static boolean isEligible(double cgpa, int codingScore) {
    return cgpa >= COMBINED_CGPA_THRESHOLD && codingScore >= COMBINED_CODING_SCORE_THRESHOLD;
}
static String shortlistAndRank(Candidate[] candidates) {
    List<Candidate> shortlisted = new ArrayList<>();
    for (Candidate c : candidates) {
        if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
            shortlisted.add(c);
        }
}
Candidate[] shortlistedArray = shortlisted.toArray(new Candidate[0]);
Arrays.sort(shortlistedArray);
StringBuilder result = new StringBuilder();
for (int i = 0; i < shortlistedArray.length; i++) {
    if (i > 0) result.append(" | ");
    result.append(i + 1).append(". ").append(shortlistedArray[i].name)
    .append(" (").append(shortlistedArray[i].compositeScore()).append(")");
}
return result.toString();
}
public static void main(String[] args) {
    Candidate[] candidates = {
        new Candidate("Aisha", 8.2, 40),
        new Candidate("Rohit", 6.8, 65),
        new Candidate("Meena", 6.0, 90),
        new Candidate("Karan", 7.5, 20)
    };
System.out.println("Output: " + shortlistAndRank(candidates));
System.out.println("Expected: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)");
}
}
