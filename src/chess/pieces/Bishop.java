package chess.pieces;

public class Bishop {
    private boolean isWhite; // Indicates whether the bishop is white or black

    public Bishop(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, boolean isCapturing) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Bishops can move diagonally any number of squares
        if (rowChange == colChange) {
            return true;
        } else {
            return false; // Invalid move
        }
    }
}
