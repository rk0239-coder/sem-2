import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;
public class P5_StopWordFilteredWordFrequencyReport {
    static final Set<String> STOP_WORDS = new HashSet<>(
    List.of("the", "was", "and", "a", "is", "of", "in"));
    static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase()
        .replace(".", "")
        .replace(",", "");
        String[] words = cleaned.split("\\s+");
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
        frequency.put(word, frequency.getOrDefault(word, 0) + 1);
    }
List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
entries.sort((e1, e2) -> e2.getValue() - e1.getValue());
for (Map.Entry<String, Integer> entry : entries) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
}
public static void main(String[] args) {
    String feedback = "The mentor was great, the session was great and clear.";
    System.out.println("Input: \"" + feedback + "\"");
    System.out.println("Output:");
    printFilteredWordFrequency(feedback);
    System.out.println("Expected: great: 2, mentor: 1, session: 1, clear: 1 (in some order among ties)");
}
}
