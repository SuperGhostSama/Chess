package chess.pieces;

public class Queen {
    private boolean isWhite; // Verifies if the piece is white or black

    public Queen(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, String[][] board) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Queens can move vertically, horizontally, or diagonally any number of squares
        if (rowChange == 0 || colChange == 0 || rowChange == colChange) {
            int rowStep = rowChange == 0 ? 0 : (newRow > currentRow ? 1 : -1);
            int colStep = colChange == 0 ? 0 : (newCol > currentCol ? 1 : -1);
            int row = currentRow + rowStep;
            int col = currentCol + colStep;

            // Check all squares in the path
            while (row != newRow || col != newCol) {
                if (!board[row][col].equals(" ")) {
                    return false; // There's a non-empty square in the path
                }
                row += rowStep;
                col += colStep;
            }

            // Check if the target square is empty or contains a piece of the opposite color
            String targetPiece = board[newRow][newCol];
            if (targetPiece.equals(" ")) {
                return true; // Move to an empty square
            } else if (isWhite && Character.isUpperCase(targetPiece.charAt(0))) {
                return true; // White queen can capture a black piece
            } else if (!isWhite && Character.isLowerCase(targetPiece.charAt(0))) {
                return true; // Black queen can capture a white piece
            }
        }

        return false;
    }
}

