package chess.pieces;

public class Bishop {
    private boolean isWhite; // Verifies if the piece is white or black

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
                return false; // There is a square in the path thats not empty
            }
            row += rowStep;
            col += colStep;
        }

        // Check if the target square is empty or contains a piece of the opposite color
        String targetPiece = board[newRow][newCol];
        if (targetPiece.equals(" ")) {
            return true; // Move to an empty square
        } else if (isWhite && Character.isUpperCase(targetPiece.charAt(0))) {
            return true; // White bishop can capture a black piece
        } else if (!isWhite && Character.isLowerCase(targetPiece.charAt(0))) {
            return true; // Black bishop can capture a white piece
        }

        return false;
    }
}

