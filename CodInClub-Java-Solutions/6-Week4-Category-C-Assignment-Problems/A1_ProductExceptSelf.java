import java.util.Arrays;
public class A1_ProductExceptSelf {
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
    int rightProduct = 1;
    for (int i = n - 1; i >= 0; i--) {
        answer[i] = answer[i] * rightProduct;
        rightProduct *= nums[i];
    }
return answer;
}
public static void main(String[] args) {
    int[] test1 = {1, 2, 3, 4};
    System.out.println("nums = " + Arrays.toString(test1));
    System.out.println("Output: " + Arrays.toString(productExceptSelf(test1)));
    System.out.println("Expected: [24, 12, 8, 6]");
    System.out.println();
    int[] test2 = {-1, 1, 0, -3, 3};
    System.out.println("nums = " + Arrays.toString(test2));
    System.out.println("Output: " + Arrays.toString(productExceptSelf(test2)));
    System.out.println("Expected: [0, 0, 9, 0, 0]");
}
}
