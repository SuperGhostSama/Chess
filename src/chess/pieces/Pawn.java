package chess.pieces;

public class Pawn {
    private boolean isWhite; // Indicates whether the pawn is white or black

    public Pawn(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int currentRow, int currentCol, int newRow, int newCol, String[][] board) {
        int rowChange = newRow - currentRow;
        int colChange = Math.abs(newCol - currentCol);

        if (isWhite) {
            // White pawns move forward one or two squares from row 2 (index 1)
            if (currentRow == 1) {
                if (rowChange == 1 || rowChange == 2) {
                    // Check if the square in front of the pawn is empty
                    if (rowChange == 2) {
                        // Check that the squares in between are empty for a two-square move
                        if (!board[currentRow + 1][currentCol].equals(" ") || !board[newRow][newCol].equals(" ")) {
                            return false;
                        }
                    }
                    return board[newRow][newCol].equals(" ");
                }
            } else {
                // White pawns in other rows can only move forward one square
                return rowChange == 1 && colChange == 0 && board[newRow][newCol].equals(" ");
            }
        } else {
            // Black pawns move forward one or two squares from row 7 (index 6)
            if (currentRow == 6) {
                if (rowChange == -1 || rowChange == -2) {
                    // Check if the square in front of the pawn is empty
                    if (rowChange == -2) {
                        // Check that the squares in between are empty for a two-square move
                        if (!board[currentRow - 1][currentCol].equals(" ") || !board[newRow][newCol].equals(" ")) {
                            return false;
                        }
                    }
                    return board[newRow][newCol].equals(" ");
                }
            } else {
                // Black pawns in other rows can only move forward one square
                return rowChange == -1 && colChange == 0 && board[newRow][newCol].equals(" ");
            }
        }
        return false;
    }



}
