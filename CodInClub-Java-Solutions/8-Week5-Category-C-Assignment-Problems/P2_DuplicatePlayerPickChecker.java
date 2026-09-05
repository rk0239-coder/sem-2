public class P2_DuplicatePlayerPickChecker {
    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
        }
}
return "No Duplicates Found";
}
public static void main(String[] args) {
    String[] test1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
    System.out.println("Output: " + findDuplicatePick(test1));
    System.out.println("Expected: Duplicate Found: Kohli");
    System.out.println();
    String[] test2 = {"Kohli", "Bumrah", "Rohit"};
    System.out.println("Output: " + findDuplicatePick(test2));
    System.out.println("Expected: No Duplicates Found");
}
}
