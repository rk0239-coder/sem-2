public class P1_VowelConsonantCounter {
    static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        String vowelSet = "aeiouAEIOU";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') continue;
            if (vowelSet.indexOf(c) != -1) {
                vowels++;
            } else if (Character.isLetter(c)) {
            consonants++;
        }
}
System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
}
public static void main(String[] args) {
    String text = "Java Programming";
    System.out.print("\"" + text + "\" -> ");
    countVowelsAndConsonants(text);
    System.out.println("Expected: Vowels: 5 | Consonants: 10");
}
}
