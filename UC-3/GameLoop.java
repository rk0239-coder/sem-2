import java.util.Scanner;
import java.util.Random;

class GameLoop {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static int[] convertSlotToPosition(int slot) {
        int index = slot - 1;
        return new int[]{index / 3, index % 3};
    }

    public static boolean isValidMove(char[][] board, int row, int col) {
        return (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ');
    }

    public static void placeMove(char[][] board, int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(char[][] b, char s) {

        for (int i = 0; i < 3; i++) {
            if (b[i][0] == s && b[i][1] == s && b[i][2] == s) return true;
            if (b[0][i] == s && b[1][i] == s && b[2][i] == s) return true;
        }
        if (b[0][0] == s && b[1][1] == s && b[2][2] == s) return true;
        if (b[0][2] == s && b[1][1] == s && b[2][0] == s) return true;

        return false;
    }

    public static boolean isDraw(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

    public static int getUserSlot() {
        System.out.print("Enter slot (1-9): ");
        return sc.nextInt();
    }

    public static void computerMove(char[][] board, char symbol) {
        while (true) {
            int slot = rand.nextInt(9) + 1;
            int[] pos = convertSlotToPosition(slot);

            if (isValidMove(board, pos[0], pos[1])) {
                placeMove(board, pos[0], pos[1], symbol);
                System.out.println("Computer chose: " + slot);
                break;
            }
        }
    }

    public static void main(String[] args) {

        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        char currentSymbol = 'X';
        boolean gameOver = false;

        while (!gameOver) {

            printBoard(board);

            if (currentSymbol == 'X') {

                int slot = getUserSlot();
                int[] pos = convertSlotToPosition(slot);

                if (isValidMove(board, pos[0], pos[1])) {
                    placeMove(board, pos[0], pos[1], currentSymbol);
                } else {
                    System.out.println("Invalid move! Try again.");
                    continue;
                }

            } else {

                computerMove(board, currentSymbol);
            }

            if (checkWin(board, currentSymbol)) {
                printBoard(board);
                System.out.println(currentSymbol + " Wins!");
                gameOver = true;
            }

            else if (isDraw(board)) {
                printBoard(board);
                System.out.println("Game Draw!");
                gameOver = true;
            }

            else {
                currentSymbol = (currentSymbol == 'X') ? 'O' : 'X';
            }
        }
    }
}