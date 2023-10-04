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
            // Check if the destination square is empty or contains a piece of the opposite color
            String targetPiece = board[newRow][newCol];
            if (targetPiece.equals(" ")) {
                return true; // Move to an empty square
            } else if (isWhite && Character.isUpperCase(targetPiece.charAt(0))) {
                return true; // White knight can capture a black piece
            } else if (!isWhite && Character.isLowerCase(targetPiece.charAt(0))) {
                return true; // Black knight can capture a white piece
            }
        }

        return false;
    }
}

