package chess.game;

public class ChessGame {
    private String[][] board;

    public ChessGame() {
        // Initialize the chessboard
        board = new String[8][8];
        setupInitialPosition();
    }

    private void setupInitialPosition() {
        // Initialize black pieces
        board[0][0] = "r"; // Black Rook
        board[0][1] = "n"; // Black Knight
        board[0][2] = "b"; // Black Bishop
        board[0][3] = "q"; // Black Queen
        board[0][4] = "k"; // Black King
        board[0][5] = "b"; // Black Bishop
        board[0][6] = "n"; // Black Knight
        board[0][7] = "r"; // Black Rook

        for (int col = 0; col < 8; col++) {
            board[1][col] = "p"; // Black Pawns
        }

        // Initialize white pieces
        board[7][0] = "R"; // White Rook
        board[7][1] = "N"; // White Knight
        board[7][2] = "B"; // White Bishop
        board[7][3] = "Q"; // White Queen
        board[7][4] = "K"; // White King
        board[7][5] = "B"; // White Bishop
        board[7][6] = "N"; // White Knight
        board[7][7] = "R"; // White Rook

        for (int col = 0; col < 8; col++) {
            board[6][col] = "P"; // White Pawns
        }

        // Fill the remaining squares with empty squares
        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = " "; // Empty square
            }
        }
    }

    public void displayBoard() {
        System.out.println("   a  b  c  d  e  f  g  h "); // Column labels

        for (int row = 0; row < 8; row++) {
            System.out.print(8 - row + " "); // Row label

            for (int col = 0; col < 8; col++) {
                String piece = board[row][col];
                System.out.print("|" + piece + "|");
            }
            System.out.print(" " + (8 - row)); // Row label (right side)
            System.out.println();
        }

        System.out.println("   a  b  c  d  e  f  g  h "); // Column labels
    }
}
