import java.util.Arrays;

public class Problem8_DutyRosterRotation {
    // Rotate right by k places.
    // Time: O(n), Space: O(n) for the result.
    // Rotating one place at a time k times costs O(n * k), which is far too
    // slow when k is up to 10^9; k % n removes full turns.
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[(i + shift) % n] = names[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2))); // [D, E, A, B, C]
        System.out.println(Arrays.toString(rotateRoster(names, 7))); // [D, E, A, B, C]
    }
}
