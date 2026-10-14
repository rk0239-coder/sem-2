import java.util.Arrays;

public class Problem4_InPlaceReversal {
    public static void reverse(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] tokens = {11, 22, 33, 44};
        reverse(tokens);
        System.out.println(Arrays.toString(tokens));
    }
}
