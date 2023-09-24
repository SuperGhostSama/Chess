package chess.pieces;

public class Rook {
    private boolean isWhite; // Indicates whether the rook is white or black

    public Rook(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, boolean isCapturing) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Rooks can move horizontally or vertically any number of squares
        if (currentRow == newRow || currentCol == newCol) {
            return true;
        } else {
            return false; // Invalid move
        }
    }
}
