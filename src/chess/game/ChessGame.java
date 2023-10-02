package chess.game;


import chess.pieces.*;

import java.util.Scanner;

public class ChessGame {
    private String[][] board;
    private boolean isWhiteTurn;

    public ChessGame() {
        // Initialize the chessboard
        board = new String[8][8];
        setupInitialPosition();
    }

    private void setupInitialPosition() {
        // Initialize white pieces
        board[0][0] = "r"; // White Rook
        board[0][1] = "n"; // White Knight
        board[0][2] = "b"; // White Bishop
        board[0][3] = "q"; // White Queen
        board[0][4] = "k"; // White King
        board[0][5] = "b"; // White Bishop
        board[0][6] = "n"; // White Knight
        board[0][7] = "r"; // White Rook

        for (int col = 0; col < 8; col++) {
            board[1][col] = "p"; // White Pawns
        }

        // Initialize black pieces
        board[7][0] = "R"; // Black Rook
        board[7][1] = "N"; // Black Knight
        board[7][2] = "B"; // Black Bishop
        board[7][3] = "Q"; // Black Queen
        board[7][4] = "K"; // Black King
        board[7][5] = "B"; // Black Bishop
        board[7][6] = "N"; // Black Knight
        board[7][7] = "R"; // Black Rook

        for (int col = 0; col < 8; col++) {
            board[6][col] = "P"; // Black Pawns
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

        for (int row = 7; row >= 0; row--) { // Start from 7 (row 8) and go down to 0 (row 1)
            System.out.print((row + 1) + " "); // Row label (add 1 to row to start from 1)

            for (int col = 0; col < 8; col++) {
                String piece = board[row][col];
                System.out.print("|" + piece + "|");
            }
            System.out.print(" " + (row + 1)); // Row label (right side)
            System.out.println();
        }

        System.out.println("   a  b  c  d  e  f  g  h "); // Column labels
    }


    private boolean isValidSquare(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public void startNewGame() {
        System.out.println("Starting a new game. White player goes first.");

        Scanner scanner = new Scanner(System.in);
        isWhiteTurn = true;

        while (true) {
            displayBoard(); // Display the board before each player's turn

            String playerColor = isWhiteTurn ? "White" : "Black";
            System.out.println(playerColor + " player's turn.");

            // FromSquare
            System.out.print("Enter the square/chess piece to move (e.g., 'e2'): ");
            String fromSquare = scanner.nextLine();

            // Extract the row and column from 'fromSquare'
            int fromRow, fromCol;
            try {
                char columnChar = fromSquare.charAt(0);
                fromRow = Character.getNumericValue(fromSquare.charAt(1)) - 1; // Adjust for 0-based indexing

                // Map columnChar to column index
                fromCol = switch (columnChar) {
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
                if (!isValidSquare(fromRow, fromCol)) {
                    throw new IllegalArgumentException("Invalid row or column value.");
                }
            } catch (Exception e) {
                System.out.println("Invalid square format. Please enter a valid square (e.g., 'e2').");
                continue; // Ask for input again
            }

            // Now you have 'fromRow' and 'fromCol' representing the selected square
            // Call the getPieceType method to identify the type of piece on that square
            String pieceType = getPieceType(fromRow, fromCol, isWhiteTurn);

            if ("Empty".equals(pieceType)) {
                System.out.println("The selected square is empty. Please choose a square with a chess piece.");
                continue; // Ask for input again
            } else if ("Opponent's Piece".equals(pieceType)) {
                System.out.println("You can only move your own pieces.");
                continue; // Ask for input again
            }

            System.out.println("You selected a " + pieceType + " on the square.");

            // ToSquare
            System.out.print("Enter the destination square (e.g., 'e4'): ");
            String toSquare = scanner.nextLine();

            // Extract the row and column from 'toSquare'
            int toRow, toCol;
            try {
                char columnChar = toSquare.charAt(0);
                toRow = Character.getNumericValue(toSquare.charAt(1)) - 1; // Adjust for 0-based indexing

                // Map columnChar to column index
                toCol = switch (columnChar) {
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
                if (!isValidSquare(toRow, toCol)) {
                    throw new IllegalArgumentException("Invalid row or column value.");
                }
            } catch (Exception e) {
                System.out.println("Invalid square format. Please enter a valid square (e.g., 'e2').");
                continue; // Ask for input again
            }

            // Check if the selected piece can move to the destination square
            boolean isValidMove = isValidMove(fromRow, fromCol, toRow, toCol, pieceType);

            if (isValidMove) {
                System.out.println("Valid move. The " + pieceType + " can move to " + toSquare + ".");
                // Implement the move logic here
                // Update the board based on the move
                board[toRow][toCol] = board[fromRow][fromCol];
                board[fromRow][fromCol] = " "; // Empty the old square
            } else {
                System.out.println("Invalid move. The " + pieceType + " cannot move to " + toSquare + ".");
                continue; // Ask for input again
            }

            // Toggle player turn
            isWhiteTurn = !isWhiteTurn;
        }
    }


    private boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, String pieceType) {
        // Check if the move is valid for the given chess piece type
        switch (pieceType) {
            case "Pawn" -> {
                Pawn pawn = new Pawn(isWhiteTurn);
                return pawn.isValidMove(fromRow, fromCol, toRow, toCol, board);
            }
            case "Rook" -> {
                Rook rook = new Rook(isWhiteTurn);
                return rook.isValidMove(fromRow, fromCol, toRow, toCol, board);
            }
            case "Knight" -> {
                Knight knight = new Knight(isWhiteTurn);
                return knight.isValidMove(fromRow, fromCol, toRow, toCol, board);
            }
            case "Bishop" -> {
                Bishop bishop = new Bishop(isWhiteTurn);
                return bishop.isValidMove(fromRow, fromCol, toRow, toCol);
            }
            case "Queen" -> {
                Queen queen = new Queen(isWhiteTurn);
                return queen.isValidMove(fromRow, fromCol, toRow, toCol);
            }
            case "King" -> {
                King king = new King(isWhiteTurn);
                return king.isValidMove(fromRow, fromCol, toRow, toCol);
            }
            default -> {
                return false; // Unknown piece type or invalid move
            }
        }
    }




    public String getPieceType(int row, int col, boolean isWhiteTurn) {
        String piece = board[row][col];
        if (piece != null && !piece.trim().isEmpty()) {
            // Determine the piece color (uppercase for black, lowercase for white)
            char pieceColor = Character.isUpperCase(piece.charAt(0)) ? 'B' : 'W';

            // Determine the current player's color
            char currentPlayerColor = isWhiteTurn ? 'W' : 'B';

            // Check if the square contains a piece of the current player's color
            if (pieceColor == currentPlayerColor) {
                // If the square is not empty and belongs to the current player, return the type of piece
                switch (piece.toUpperCase()) {
                    case "P": return "Pawn";
                    case "R": return "Rook";
                    case "N": return "Knight";
                    case "B": return "Bishop";
                    case "Q": return "Queen";
                    case "K": return "King";
                    default: return "Unknown";
                }
            } else {
                return "Opponent's Piece"; // Piece belongs to the opponent
            }
        }
        return "Empty";
    }





}
