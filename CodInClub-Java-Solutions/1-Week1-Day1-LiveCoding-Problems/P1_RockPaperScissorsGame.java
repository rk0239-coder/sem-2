import java.util.Random;
public class P1_RockPaperScissorsGame {
    static String[] MOVES = {"Rock", "Paper", "Scissors"};
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
    if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
    (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
    (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
        return "Player Wins";
    }
return "Computer Wins";
}
public static void main(String[] args) {
    Random random = new Random();
    String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
    int wins = 0, losses = 0, draws = 0;
    String[][] table = new String[playerMoves.length][3];
    System.out.println("Round | Player Move | Computer Move | Result");
    System.out.println("---------------------------------------------");
    for (int round = 0; round < playerMoves.length; round++) {
        String playerMove = playerMoves[round];
        String computerMove = MOVES[random.nextInt(3)];
        String result = playRound(playerMove, computerMove);
        if (result.equals("Player Wins")) wins++;
        else if (result.equals("Computer Wins")) losses++;
        else draws++;
        System.out.printf("%5d | %-11s | %-14s | %s%n",
        round + 1, playerMove, computerMove, result);
    }
double winPercentage = (wins * 100.0) / playerMoves.length;
System.out.println();
System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
wins, losses, draws, winPercentage);
}
}
