import java.util.LinkedHashMap;
import java.util.Map;
public class P4_FirstNonRepeatingCharacter {
    static Character findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequency = new LinkedHashMap<>();
        for (char c : text.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
    for (char c : text.toCharArray()) {
        if (frequency.get(c) == 1) {
            return c;
        }
}
return null;
}
public static void main(String[] args) {
    String[] tests = {"swiss", "aabbcc"};
    for (String text : tests) {
        Character result = findFirstNonRepeatingChar(text);
        System.out.println("\"" + text + "\" -> " +
        (result != null
        ? "First Non-Repeating Character: '" + result + "'"
        : "No Non-Repeating Character Found"));
    }
}
}
