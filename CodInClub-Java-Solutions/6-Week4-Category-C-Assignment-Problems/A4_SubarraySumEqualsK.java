import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class A4_SubarraySumEqualsK {
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int currentSum = 0;
        int count = 0;
        for (int num : nums) {
            currentSum += num;
            count += prefixCount.getOrDefault(currentSum - k, 0);
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }
    return count;
}
public static void main(String[] args) {
    int[] test1 = {1, 1, 1};
    System.out.println("nums = " + Arrays.toString(test1) + ", k = 2");
    System.out.println("Output: " + subarraySum(test1, 2) + " (Expected: 2)");
    System.out.println();
    int[] test2 = {1, -1, 0};
    System.out.println("nums = " + Arrays.toString(test2) + ", k = 0");
    System.out.println("Output: " + subarraySum(test2, 0) + " (Expected: 3)");
}
}
