package chess.pieces;

public class Pawn {
    private boolean isWhite; // Indicates whether the pawn is white or black

    public Pawn(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, boolean isCapturing) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Pawns can move forward one square or capture diagonally one square
        if (isWhite) {
            if (currentRow - newRow == 1) {
                // Moving forward one square
                return !isCapturing && colChange == 0;
            } else if (currentRow - newRow == 1 && colChange == 1) {
                // Capturing diagonally
                return isCapturing;
            } else {
                return false; // Invalid move
            }
        } else {
            if (newRow - currentRow == 1) {
                // Moving forward one square
                return !isCapturing && colChange == 0;
            } else if (newRow - currentRow == 1 && colChange == 1) {
                // Capturing diagonally
                return isCapturing;
            } else {
                return false; // Invalid move
            }
        }
    }
}
