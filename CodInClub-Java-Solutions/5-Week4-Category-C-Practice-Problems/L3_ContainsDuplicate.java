import java.util.Arrays;
public class L3_ContainsDuplicate {
    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
        }
}
return false;
}
public static void main(String[] args) {
    int[] test1 = {1, 2, 3, 1};
    System.out.println("nums = " + Arrays.toString(test1));
    System.out.println("Output: " + containsDuplicate(test1) + " (Expected: true)");
    System.out.println();
    int[] test2 = {1, 2, 3, 4};
    System.out.println("nums = " + Arrays.toString(test2));
    System.out.println("Output: " + containsDuplicate(test2) + " (Expected: false)");
}
}
