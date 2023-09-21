public class Square {
    private int row;
    private int col;
    private ChessPiece piece;

    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        this.piece = null; // Initialize as empty
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }
}
