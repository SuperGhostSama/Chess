package chess;

import chess.game.ChessGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Chess Game Menu:");
            System.out.println("1. Start New Game");
            System.out.println("2. View Saved Games");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Start a new game
                    ChessGame chessGame = new ChessGame();
                    chessGame.startNewGame();
                    break;
                case 2:
                    // View saved games (implement this functionality)
                    viewSavedGames();
                    break;
                case 3:
                    // Exit the game
                    System.out.println("Exiting Chess Game. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }



    private static void viewSavedGames() {
        // Implement the logic to view saved games
        System.out.println("Viewing saved games...");
    }
}
