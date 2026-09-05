import java.util.Arrays;
public class L1_TwoSum {
    static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
        }
}
throw new IllegalArgumentException("No valid pair found");
}
public static void main(String[] args) {
    int[] test1 = {2, 7, 11, 15};
    System.out.println("nums = " + Arrays.toString(test1) + ", target = 9");
    System.out.println("Output: " + Arrays.toString(twoSum(test1, 9)) + " (Expected: [0, 1])");
    System.out.println();
    int[] test2 = {3, 2, 4};
    System.out.println("nums = " + Arrays.toString(test2) + ", target = 6");
    System.out.println("Output: " + Arrays.toString(twoSum(test2, 6)) + " (Expected: [1, 2])");
}
}
