package chess.pieces;

public class Queen {
    private boolean isWhite; // Indicates whether the queen is white or black

    public Queen(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, boolean isCapturing) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Queens can move horizontally, vertically, or diagonally any number of squares
        if (rowChange == colChange || currentRow == newRow || currentCol == newCol) {
            return true;
        } else {
            return false; // Invalid move
        }
    }
}
