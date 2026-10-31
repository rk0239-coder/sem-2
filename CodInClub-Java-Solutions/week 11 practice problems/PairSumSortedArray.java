public class PairSumSortedArray {
    static String pairSumSorted(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum == target) return "(" + nums[lo] + ", " + nums[hi] + ")";
            else if (sum < target) lo++;
            else hi--;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        int[] n1 = {-4, -1, 0, 3, 5, 9};
        int[] n2 = {1, 2, 3};
        System.out.println(pairSumSorted(n1, 4));
        System.out.println(pairSumSorted(n2, 100));
    }
}
