import java.util.Arrays;
public class P3_TopThreePodiumFinder {
    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;
        for (int score : scores) {
            if (score > first) {
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
            third = second;
            second = score;
        } else if (score > third) {
        third = score;
    }
}
return new int[]{first, second, third};
}
public static void main(String[] args) {
    int[] test = {45, 82, 79, 90, 33, 90, 61};
    System.out.println("scores = " + Arrays.toString(test));
    System.out.println("Output: " + Arrays.toString(findTopThreeScores(test)));
    System.out.println("Expected: [90, 90, 82]");
}
}
