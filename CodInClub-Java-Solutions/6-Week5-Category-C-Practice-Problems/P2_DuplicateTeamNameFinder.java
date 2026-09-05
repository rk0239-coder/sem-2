public class P2_DuplicateTeamNameFinder {
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
        }
}
return "No Duplicates Found";
}
public static void main(String[] args) {
    String[] test1 = {"ByteForce", "CodeCrafters", "ByteForce"};
    System.out.println("Output: " + findDuplicateTeam(test1));
    System.out.println("Expected: Duplicate Found: ByteForce");
    System.out.println();
    String[] test2 = {"ByteForce", "CodeCrafters", "NullPointers"};
    System.out.println("Output: " + findDuplicateTeam(test2));
    System.out.println("Expected: No Duplicates Found");
}
}
