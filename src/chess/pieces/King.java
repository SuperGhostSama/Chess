package chess.pieces;

public class King {
    private boolean isWhite; // Indicates whether the king is white or black

    public King(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, boolean isCapturing) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Kings can move one square in any direction (including diagonally)
        if (rowChange <= 1 && colChange <= 1) {
            return true;
        } else {
            return false; // Invalid move
        }
    }
}
