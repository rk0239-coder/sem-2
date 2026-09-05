public class P2_TypingSpeedTestAccuracyChecker {
    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatchPosition = -1;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPosition == -1) {
            firstMismatchPosition = i + 1;
        }
}
double accuracy = (matched * 100.0) / original.length();
StringBuilder result = new StringBuilder();
result.append("Matched: ").append(matched).append("/").append(original.length())
.append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");
if (firstMismatchPosition == -1) {
    result.append(" | No Mismatches");
} else {
int idx = firstMismatchPosition - 1;
result.append(" | First Mismatch at position ").append(firstMismatchPosition)
.append(" ('").append(original.charAt(idx)).append("' vs '")
.append(typed.charAt(idx)).append("')");
}
System.out.println(result);
}
public static void main(String[] args) {
    checkTypingAccuracy("hello world", "hello worlt");
    System.out.println("Expected: Matched: 10/11 | Accuracy: 90.91% | First Mismatch at position 11 ('d' vs 't')");
    System.out.println();
    checkTypingAccuracy("coding", "coding");
    System.out.println("Expected: Matched: 6/6 | Accuracy: 100.00% | No Mismatches");
}
}
