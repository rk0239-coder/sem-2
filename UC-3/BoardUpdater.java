class BoardUpdater {

    // Method to place symbol on the board
    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;  // Update board
    }

    // Utility method to print board (helps in testing/demo)
    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Initialize empty board
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        int row = 1;
        int col = 1;
        char symbol = 'X';

        // Assume move is already validated (UC5)
        placeMove(board, row, col, symbol);

        System.out.println("Updated Board:");
        printBoard(board);
    }
}