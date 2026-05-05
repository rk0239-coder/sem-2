import java.util.Random;

class Toss {

    public static void main(String[] args) {

        // Game State Variables
        String player1 = "Player 1";
        String player2 = "Player 2";

        String player1Symbol;
        String player2Symbol;
        String currentPlayer;

        // Random Number Generation (0 or 1)
        Random rand = new Random();
        int toss = rand.nextInt(2); // 0 or 1

        // Conditional Logic
        if (toss == 0) {
            currentPlayer = player1;
            player1Symbol = "X";
            player2Symbol = "O";
        } else {
            currentPlayer = player2;
            player2Symbol = "X";
            player1Symbol = "O";
        }

        // Output Results
        System.out.println("Toss Result: " + toss);
        System.out.println(player1 + " Symbol: " + player1Symbol);
        System.out.println(player2 + " Symbol: " + player2Symbol);
        System.out.println("First Turn: " + currentPlayer);
    }
}