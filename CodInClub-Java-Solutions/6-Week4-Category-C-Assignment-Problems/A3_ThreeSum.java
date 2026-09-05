import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class A3_ThreeSum {
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                left++;
            } else {
            right--;
        }
}
}
return result;
}
public static void main(String[] args) {
    int[] test1 = {-1, 0, 1, 2, -1, -4};
    System.out.println("nums = " + Arrays.toString(test1));
    System.out.println("Output: " + threeSum(test1));
    System.out.println("Expected: [[-1, -1, 2], [-1, 0, 1]]");
    System.out.println();
    int[] test2 = {0, 0, 0};
    System.out.println("nums = " + Arrays.toString(test2));
    System.out.println("Output: " + threeSum(test2));
    System.out.println("Expected: [[0, 0, 0]]");
}
}
