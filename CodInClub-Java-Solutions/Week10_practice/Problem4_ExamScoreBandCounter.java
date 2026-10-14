public class Problem4_ExamScoreBandCounter {
    // Count of scores s with low <= s <= high in a sorted array.
    // Linear scan: O(n) time, O(1) space.
    // This solution: O(log n) time, O(1) space.
    // Duplicates: a plain binary search stops at any match, so we search for
    // boundaries instead: first index with score >= low, and first index with score > high.
    public static int countInBand(int[] scores, int low, int high) {
        return firstGreaterOrEqual(scores, high + 1) - firstGreaterOrEqual(scores, low);
        // first index with score > high == first index with score >= high + 1
    }

    // Lower-bound binary search: first index whose value is >= target (or n if none).
    private static int firstGreaterOrEqual(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] s = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(s, 42, 58));  // 6
        System.out.println(countInBand(s, 90, 100)); // 0
    }
}
