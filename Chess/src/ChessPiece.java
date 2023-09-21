public class ChessPiece {
    private Color color;
    private PieceType pieceType;

    public ChessPiece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
    }

    public Color getColor() {
        return color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public boolean isValidMove(Square from, Square to, ChessBoard board) {
        // Implement piece-specific move validation logic
        return false;
    }

    public boolean move(Square from, Square to, ChessBoard board) {
        // Implement piece-specific move execution logic
        return false;
    }
}