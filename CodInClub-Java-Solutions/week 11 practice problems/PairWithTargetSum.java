import java.util.*;

public class PairWithTargetSum {
    static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (seen.contains(target - n)) return true;
            seen.add(n);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] n1 = {2, 7, 11, 15};
        int[] n2 = {3, 4, 6};
        System.out.println(hasPairWithSum(n1, 9));
        System.out.println(hasPairWithSum(n2, 20));
    }
}
