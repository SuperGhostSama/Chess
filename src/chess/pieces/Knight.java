package chess.pieces;

public class Knight {
    private boolean isWhite; // Verifies if the piece is white or black

    public Knight(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isValidMove(int row , int col , int newRow , int newCol , String[][] board){

        int x = Math.abs(row-newRow);
        int y = Math.abs(col-newCol);

        if(x == 1 && y == 2){
            if (board[newRow][newCol].equals(" ")){
                return true;
            }
            return false;
        } else if (x == 2 && y == 1) {
            if (board[newRow][newCol].equals(" ")){
                return true;
            }
            return false;
        }


        return false;
    }
}

