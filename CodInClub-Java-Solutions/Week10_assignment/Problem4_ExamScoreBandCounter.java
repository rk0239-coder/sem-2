public class Problem4_ExamScoreBandCounter {

    public static int countInBand(int[] scores, int low, int high) {
        return firstGreaterOrEqual(scores, high + 1) - firstGreaterOrEqual(scores, low);

    }

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
        System.out.println(countInBand(s, 42, 58));
        System.out.println(countInBand(s, 90, 100));
    }
}
