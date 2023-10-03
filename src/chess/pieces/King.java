package chess.pieces;

public class King {
    private boolean isWhite; // Indicates whether the king is white or black

    public King(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, String[][] board) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Kings can move one square in any direction
        if (rowChange <= 1 && colChange <= 1) {
            // Check if the target square is empty
            return board[newRow][newCol].equals(" ");
        }

        return false; // Invalid move
    }


}
