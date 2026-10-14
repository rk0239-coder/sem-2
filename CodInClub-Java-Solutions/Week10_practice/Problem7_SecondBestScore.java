public class Problem7_SecondBestScore {
    // Second-highest distinct score, or -1 if none. No sorting.
    // Time: O(n) single pass, Space: O(1). Sorting would be O(n log n).
    public static int secondHighest(int[] scores) {
        int highest = -1, second = -1;
        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60})); // 78
        System.out.println(secondHighest(new int[]{50, 50, 50}));         // -1
    }
}
