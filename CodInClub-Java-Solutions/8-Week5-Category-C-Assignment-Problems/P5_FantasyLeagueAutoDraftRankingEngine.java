import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class P5_FantasyLeagueAutoDraftRankingEngine {
    static final int EXPERIENCE_ONLY_THRESHOLD = 10;
    static final int COMBINED_MATCHES_THRESHOLD = 5;
    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;
        Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}
static boolean isDraftable(int matchesPlayed) {
    return matchesPlayed >= EXPERIENCE_ONLY_THRESHOLD;
}
static boolean isDraftable(int matchesPlayed, boolean injured) {
    return matchesPlayed >= COMBINED_MATCHES_THRESHOLD && !injured;
}
static String draftAndRank(Player[] players) {
    List<Player> draftable = new ArrayList<>();
    for (Player p : players) {
        if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
            draftable.add(p);
        }
}
Player[] draftableArray = draftable.toArray(new Player[0]);
Arrays.sort(draftableArray);
StringBuilder result = new StringBuilder();
for (int i = 0; i < draftableArray.length; i++) {
    if (i > 0) result.append(" | ");
    result.append(i + 1).append(". ").append(draftableArray[i].name);
}
return result.toString();
}
public static void main(String[] args) {
    Player[] players = {
        new Player("Virat", 15, 48.0, false),
        new Player("Rahul", 7, 55.0, false),
        new Player("Sameer", 3, 60.0, false),
        new Player("Dev", 12, 20.0, true)
    };
System.out.println("Output: " + draftAndRank(players));
System.out.println("Expected: 1. Rahul | 2. Virat | 3. Dev");
}
}
