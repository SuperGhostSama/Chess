import java.awt.*;

public abstract class ChessPiece {
    private PieceType type;
    private Color color;
    private Coordinate position;

    public ChessPiece(PieceType type, Color color, Coordinate position) {
        // Initialize the piece
    }

    public abstract boolean isValidMove(Coordinate destination, ChessBoard board);

}
