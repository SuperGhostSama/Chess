package chess.pieces;

public class Queen {
    private boolean isWhite; // Indicates whether the queen is white or black

    public Queen(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Queens can move vertically, horizontally, or diagonally any number of squares
        return rowChange == 0 || colChange == 0 || rowChange == colChange;
    }

}
