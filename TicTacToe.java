import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        Scanner input = new Scanner(System.in);
        char currentPlayer = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            printBoard(board);
            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.print("Enter row (1-3): ");
            int row = input.nextInt() - 1;
            System.out.print("Enter column (1-3): ");
            int col = input.nextInt() - 1;

            // Check if move is valid
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                if (board[row][col] == ' ') {
                    board[row][col] = currentPlayer;

                    // Check for win
                    if (checkWin(board, currentPlayer)) {
                        printBoard(board);
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameOver = true;
                    }
                    // Check for tie
                    else if (isBoardFull(board)) {
                        printBoard(board);
                        System.out.println("It's a tie!");
                        gameOver = true;
                    }
                    else {
                        // Switch player
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("That spot is already taken. Try again.");
                }
            } else {
                System.out.println("Invalid input. Row and column must be 1, 2, or 3.");
            }
        }

        input.close();
    }

    // Print the game board
    public static void printBoard(char[][] board) {
        System.out.println("\n  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            if (i < 2) System.out.println("\n  ---------");
        }
        System.out.println();
    }

    // Check if current player has won
    public static boolean checkWin(char[][] board, char player) {
        // Rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player &&
                 board[i][1] == player &&
                 board[i][2] == player) ||
                (board[0][i] == player &&
                 board[1][i] == player &&
                 board[2][i] == player)) {
                return true;
            }
        }

        // Diagonals
        return (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) ||
               (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player);
    }

    // Check if board is full
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}