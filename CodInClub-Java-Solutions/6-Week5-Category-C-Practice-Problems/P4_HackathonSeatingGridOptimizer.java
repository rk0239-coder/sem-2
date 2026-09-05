public class P4_HackathonSeatingGridOptimizer {
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
    return (double) sum / row.length;
}
static String classifyRows(int[][] seatingScores, int threshold) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < seatingScores.length; i++) {
        double avg = rowAverage(seatingScores[i]);
        String classification = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";
        if (i > 0) result.append(" | ");
        result.append("Row ").append(i).append(": ").append(classification);
    }
return result.toString();
}
public static void main(String[] args) {
    int[][] seatingScores = {
        {40, 50, 45},
        {85, 90, 95},
        {30, 20, 25}
    };
System.out.println("Output: " + classifyRows(seatingScores, 60));
System.out.println("Expected: Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone");
}
}
