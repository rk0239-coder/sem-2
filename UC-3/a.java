import java.util.Random;

class ComputerMove {

    static Random rand = new Random();

    // Reuse from UC4
    public static int[] convertSlotToPosition(int slot) {
        int index = slot - 1;
        int row = index / 3;
        int col = index % 3;
        return new int[]{row, col};
    }

    // Reuse from UC5
    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
    }

    // Reuse from UC6
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    // UC7: Computer move
    public static void computerPlay(char[][] board, char symbol) {

        while (true) {
            int slot = rand.nextInt(9) + 1; // 1–9

            int[] pos = convertSlotToPosition(slot);
            int row = pos[0];
            int col = pos[1];

            if (isValidMove(board, row, col)) {
                placeMove(board, row, col, symbol);
                System.out.println("Computer chose slot: " + slot);
                break; // Exit loop once valid move is made
            }
        }
    }

    // Display board (for demo)
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        computerPlay(board, 'O');

        System.out.println("Board after computer move:");
        printBoard(board);
    }
}