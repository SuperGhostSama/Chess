package chess.pieces;

public class Bishop {
    private boolean isWhite; // Indicates whether the bishop is white or black

    public Bishop(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Bishops move diagonally any number of squares
        return rowChange == colChange;
    }

}
