package chess.pieces;

public class Rook {
    private boolean isWhite; // Indicates whether the rook is white or black

    public Rook(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol) {
        int rowChange = newRow - currentRow;
        int colChange = newCol - currentCol;

        // Rooks can move vertically or horizontally any number of squares
        return rowChange == 0 || colChange == 0;
    }

}
