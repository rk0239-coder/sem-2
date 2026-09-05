import java.util.Arrays;
public class L5_RotateArray {
    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }
    return newArray;
}
public static void main(String[] args) {
    int[] test1 = {1, 2, 3, 4, 5, 6, 7};
    System.out.println("nums = " + Arrays.toString(test1) + ", k = 3");
    System.out.println("Output: " + Arrays.toString(rotateArray(test1, 3)) + " (Expected: [5, 6, 7, 1, 2, 3, 4])");
    System.out.println();
    int[] test2 = {1, 2};
    System.out.println("nums = " + Arrays.toString(test2) + ", k = 3");
    System.out.println("Output: " + Arrays.toString(rotateArray(test2, 3)) + " (Expected: [2, 1])");
}
}
