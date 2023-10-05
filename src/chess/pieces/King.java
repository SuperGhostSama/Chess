package chess.pieces;

public class King {
    private boolean isWhite;// Verifies if the piece is white or black

    public King(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, String[][] board) {
        int rowChange = Math.abs(newRow - currentRow);
        int colChange = Math.abs(newCol - currentCol);

        // Kings can move one square in any direction
        if (rowChange <= 1 && colChange <= 1) {
            // Check if the target square is empty or contains a piece of the opposite color
            String targetPiece = board[newRow][newCol];
            if (targetPiece.equals(" ")) {
                return true; // Move to an empty square
            } else if (isWhite && Character.isUpperCase(targetPiece.charAt(0))) {
                return true; // White king can capture a black piece
            } else if (!isWhite && Character.isLowerCase(targetPiece.charAt(0))) {
                return true; // Black king can capture a white piece
            }
        }

        return false;
    }
}

