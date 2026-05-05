class MoveValidator {

    // Method to validate move
    public static boolean isValidMove(char[][] board, int row, int col) {

        // Boundary checking
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        // Check if cell is empty
        if (board[row][col] != ' ') {
            return false;
        }

        return true; // Valid move
    }

    public static void main(String[] args) {

        // Sample 3x3 board initialized with empty spaces
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        int row = 1;
        int col = 1;

        if (isValidMove(board, row, col)) {
            System.out.println("Move Accepted");
        } else {
            System.out.println("Invalid Move");
        }
    }
}