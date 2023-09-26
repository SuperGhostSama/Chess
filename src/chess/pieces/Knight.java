package chess.pieces;

public class Knight {
    private boolean isWhite; // Indicates whether the knight is white or black

    public Knight(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, String[][] board) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Knights move in an L-shape: 2 squares in one direction and 1 square in the other
        if ((rowChange == 2 && colChange == 1) || (rowChange == 1 && colChange == 2)) {
            // Check if the destination square is empty
            return board[newRow][newCol].equals(" ");
        }

        return false;
    }

}
