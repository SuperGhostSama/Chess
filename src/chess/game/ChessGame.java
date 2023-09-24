package chess.game;

import java.util.Scanner;

public class ChessGame {
    private String[][] board;

    public ChessGame() {
        // Initialize the chessboard
        board = new String[8][8];
        setupInitialPosition();
    }

    private void setupInitialPosition() {
        // Initialize black pieces
        board[0][0] = "r"; // Black Rook
        board[0][1] = "n"; // Black Knight
        board[0][2] = "b"; // Black Bishop
        board[0][3] = "q"; // Black Queen
        board[0][4] = "k"; // Black King
        board[0][5] = "b"; // Black Bishop
        board[0][6] = "n"; // Black Knight
        board[0][7] = "r"; // Black Rook

        for (int col = 0; col < 8; col++) {
            board[1][col] = "p"; // Black Pawns
        }

        // Initialize white pieces
        board[7][0] = "R"; // White Rook
        board[7][1] = "N"; // White Knight
        board[7][2] = "B"; // White Bishop
        board[7][3] = "Q"; // White Queen
        board[7][4] = "K"; // White King
        board[7][5] = "B"; // White Bishop
        board[7][6] = "N"; // White Knight
        board[7][7] = "R"; // White Rook

        for (int col = 0; col < 8; col++) {
            board[6][col] = "P"; // White Pawns
        }

        // Fill the remaining squares with empty squares
        for (int row = 2; row < 6; row++) {
            for (int col = 0; col < 8; col++) {
                board[row][col] = " "; // Empty square
            }
        }
    }

    public void displayBoard() {
        System.out.println("   a  b  c  d  e  f  g  h "); // Column labels

        for (int row = 0; row < 8; row++) {
            System.out.print(8 - row + " "); // Row label

            for (int col = 0; col < 8; col++) {
                String piece = board[row][col];
                System.out.print("|" + piece + "|");
            }
            System.out.print(" " + (8 - row)); // Row label (right side)
            System.out.println();
        }

        System.out.println("   a  b  c  d  e  f  g  h "); // Column labels
    }

    public void startNewGame() {
        System.out.println("Starting a new game. White player goes first.");

        Scanner scanner = new Scanner(System.in);
        boolean isWhiteTurn = true;

        while (true) {
            displayBoard(); // Display the board before each player's turn

            String playerColor = isWhiteTurn ? "White" : "Black";
            System.out.println(playerColor + " player's turn.");

            //FromSquare
            System.out.print("Enter the square/chess piece to move (e.g., 'e2'): ");
            String fromSquare = scanner.nextLine();

            // Extract the row and column from 'fromSquare'
            int row, col;
            try {
                char columnChar = fromSquare.charAt(0);
                row = Character.getNumericValue(fromSquare.charAt(1)) - 1; // Adjust for 0-based indexing

                // Map columnChar to column index
                col = switch (columnChar) {
                    case 'a' -> 0;
                    case 'b' -> 1;
                    case 'c' -> 2;
                    case 'd' -> 3;
                    case 'e' -> 4;
                    case 'f' -> 5;
                    case 'g' -> 6;
                    case 'h' -> 7;
                    default -> throw new IllegalArgumentException("Invalid column character.");
                };

                // Check if the extracted row and column values are within the valid range
                if (row < 0 || row > 7) {
                    throw new IllegalArgumentException("Invalid row or column value.");
                }
            } catch (Exception e) {
                System.out.println("Invalid square format. Please enter a valid square (e.g., 'e2').");
                continue; // Ask for input again
            }


            // Now you have 'row' and 'col' representing the selected square
            // Call the getPieceType method to identify the type of piece on that square
            String pieceType = getPieceType(row, col);

            if ("Empty".equals(pieceType)) {
                System.out.println("The selected square is empty. Please choose a square with a chess piece.");
                continue; // Ask for input again
            }

            System.out.println("You selected a " + pieceType + " on the square.");

            // Continue with the rest of the move and game logic
            // ...













            //ToSquare
            System.out.print("Enter the destination square (e.g., 'e4'): ");
            String toSquare = scanner.nextLine();

            // Validate the input, implement move logic, and update the board
            // Example: You can add a method like "makeMove" to handle the move logic

            // Toggle player turn
            isWhiteTurn = !isWhiteTurn;
        }
    }

    public String getPieceType(int row, int col) {
        String piece = board[row][col];
        if (piece != null && !piece.trim().isEmpty()) {
            // If the square is not empty, return the type of piece (e.g., "Pawn", "King", etc.)
            switch (piece) {
                case "P": return "Pawn";
                case "R": return "Rook";
                case "N": return "Knight";
                case "B": return "Bishop";
                case "Q": return "Queen";
                case "K": return "King";
                case "p": return "Pawn";
                case "r": return "Rook";
                case "n": return "Knight";
                case "b": return "Bishop";
                case "q": return "Queen";
                case "k": return "King";
                default: return "Unknown";
            }
        }
        return "Empty";
    }


}
