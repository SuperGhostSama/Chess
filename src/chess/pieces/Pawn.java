package chess.pieces;

public class Pawn {
    private boolean isWhite; // Indicates whether the pawn is white or black

    public Pawn(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, String[][] board) {
        int rowChange = newRow - currentRow;
        int colChange = Math.abs(newCol - currentCol);

        if (isWhite) {
            // White pawns move forward one square (from lower row number to higher row number)
            if (rowChange == 1 && colChange == 0) {
                // Check if the square in front of the pawn is empty
                return board[newRow][newCol].equals(" ");
            } else {
                return false;
            }
        } else {
            // Black pawns move forward one square (from higher row number to lower row number)
            if (rowChange == -1 && colChange == 0) {
                // Check if the square in front of the pawn is empty
                return board[newRow][newCol].equals(" ");
            } else {
                return false;
            }
        }
    }


}
