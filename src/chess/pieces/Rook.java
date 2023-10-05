package chess.pieces;

public class Rook {
    private boolean isWhite; // Verifies if the piece is white or black

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

        // Check if the target square is empty or contains a piece of the opposite color
        String targetPiece = board[newRow][newCol];
        if (targetPiece.equals(" ")) {
            return true; // Move to an empty square
        } else if (isWhite && Character.isUpperCase(targetPiece.charAt(0))) {
            return true; // White rook can capture a black piece
        } else if (!isWhite && Character.isLowerCase(targetPiece.charAt(0))) {
            return true; // Black rook can capture a white piece
        }

        return false;
    }
}
