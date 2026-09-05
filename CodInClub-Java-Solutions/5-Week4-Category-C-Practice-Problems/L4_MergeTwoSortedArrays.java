import java.util.Arrays;
public class L4_MergeTwoSortedArrays {
    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
            result[k++] = arr2[j++];
        }
}
while (i < arr1.length) {
    result[k++] = arr1[i++];
}
while (j < arr2.length) {
    result[k++] = arr2[j++];
}
return result;
}
public static void main(String[] args) {
    int[] a1 = {1, 3, 5};
    int[] a2 = {2, 4, 6};
    System.out.println("arr1 = " + Arrays.toString(a1) + ", arr2 = " + Arrays.toString(a2));
    System.out.println("Output: " + Arrays.toString(mergeSortedArrays(a1, a2)) + " (Expected: [1, 2, 3, 4, 5, 6])");
    System.out.println();
    int[] b1 = {};
    int[] b2 = {1, 2, 3};
    System.out.println("arr1 = " + Arrays.toString(b1) + ", arr2 = " + Arrays.toString(b2));
    System.out.println("Output: " + Arrays.toString(mergeSortedArrays(b1, b2)) + " (Expected: [1, 2, 3])");
}
}
