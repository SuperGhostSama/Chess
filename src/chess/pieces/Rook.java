package chess.pieces;

public class Rook {
    private boolean isWhite; // Indicates whether the rook is white or black

    public Rook(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, String[][] board) {
        int rowChange = newRow - currentRow;
        int colChange = newCol - currentCol;

        if (rowChange == 0 && colChange <= 8) {
            int step = newCol > currentCol ? 1 : -1;
            int col = currentCol + step;
            while (col != newCol) {
                if (!board[currentRow][col].equals(" ")) {
                    return false; // There's a non-empty square in the path
                }
                col += step;
            }
        } else if (colChange == 0 && rowChange <= 8) {
            int step = newRow > currentRow ? 1 : -1;
            int row = currentRow + step;
            while (row != newRow) {
                if (!board[row][currentCol].equals(" ")) {
                    return false; // There's a non-empty square in the path
                }
                row += step;
            }
        } else {
            return false; // Rook is not moving vertically or horizontally within the specified range
        }

        // Check if the target square is empty
        return board[newRow][newCol].equals(" ");
    }


}

