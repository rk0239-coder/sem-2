import java.util.Arrays;
public class A5_FindMinimumInRotatedSortedArray {
    static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
            right = mid;
        }
}
return nums[left];
}
public static void main(String[] args) {
    int[] test1 = {3, 4, 5, 1, 2};
    System.out.println("nums = " + Arrays.toString(test1));
    System.out.println("Output: " + findMin(test1) + " (Expected: 1)");
    System.out.println();
    int[] test2 = {4, 5, 6, 7, 0, 1, 2};
    System.out.println("nums = " + Arrays.toString(test2));
    System.out.println("Output: " + findMin(test2) + " (Expected: 0)");
    System.out.println();
    int[] test3 = {11, 13, 15, 17};
    System.out.println("nums = " + Arrays.toString(test3));
    System.out.println("Output: " + findMin(test3) + " (Expected: 11)");
}
}
