package chess.pieces;

public class Bishop {
    private boolean isWhite; // Indicates whether the bishop is white or black

    public Bishop(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, String[][] board) {
        int rowChange = newRow - currentRow;
        int colChange = newCol - currentCol;

        // Check if the bishop is moving diagonally
        if (Math.abs(rowChange) != Math.abs(colChange)) {
            return false; // Bishop must move diagonally
        }

        int rowStep = rowChange > 0 ? 1 : -1;
        int colStep = colChange > 0 ? 1 : -1;
        int row = currentRow + rowStep;
        int col = currentCol + colStep;

        // Check all squares in the diagonal path
        while (row != newRow && col != newCol) {
            if (!board[row][col].equals(" ")) {
                return false; // There's a non-empty square in the path
            }
            row += rowStep;
            col += colStep;
        }

        // Check if the target square is empty
        return board[newRow][newCol].equals(" ");
    }


}
