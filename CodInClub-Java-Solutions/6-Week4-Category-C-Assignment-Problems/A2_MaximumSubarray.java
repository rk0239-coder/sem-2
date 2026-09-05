import java.util.Arrays;
public class A2_MaximumSubarray {
    static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
    return maxSum;
}
public static void main(String[] args) {
    int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println("nums = " + Arrays.toString(test1));
    System.out.println("Output: " + maxSubArray(test1) + " (Expected: 6)");
    System.out.println();
    int[] test2 = {-3, -1, -2};
    System.out.println("nums = " + Arrays.toString(test2));
    System.out.println("Output: " + maxSubArray(test2) + " (Expected: -1)");
}
}
