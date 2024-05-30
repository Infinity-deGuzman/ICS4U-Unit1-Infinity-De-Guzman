/*
 * This program lets the user play rock, paper, scissors.
 *
 * Author:  Infinity de Guzman
 * Version: 1.0
 * Since:   2024-05-27
 */

import java.util.Random;
import java.util.Scanner;

/**
 * A class that allows the user to play a game of rock, paper, scissors.
 * <p>
 * Author:  Infinity
 * Version: 1.0
 * Since:   2024-05-27
 * </p>
 */

public class RockPaperScissors {
    public static void main(String[] args) {
        // Array of moves
        String[] moves = {"rock", "paper", "scissors"};

        // Get a random move for computer
        String computerMove = getRandomMove(moves);

        // Get player's move
        String playerMove = getPlayerMove(moves);

        // Determine the winner and display the result
        String result = determineWinner(playerMove, computerMove);
        System.out.println("Player move: " + playerMove);
        System.out.println("Computer move: " + computerMove);
        System.out.println(result);
    }

    // Method to get a random move for computer
    public static String getRandomMove(String[] moves) {
        Random rand = new Random();
        int index = rand.nextInt(moves.length);
        return moves[index];
    }

    // Method to get player's move
    public static String getPlayerMove(String[] moves) {
        Scanner scanner = new Scanner(System.in);
        String playerMove;
        while (true) {
            System.out.print("Enter rock, paper, or scissors: ");
            playerMove = scanner.nextLine().toLowerCase();
            if (isValidMove(playerMove, moves)) {
                break;
            } else {
                System.out.println("Invalid move. Please enter rock, paper, or scissors.");
            }
        }
        return playerMove;
    }

    // Method to check if player's move is valid
    public static boolean isValidMove(String move, String[] moves) {
        for (String validMove : moves) {
            if (move.equals(validMove)) {
                return true;
            }
        }
        return false;
    }

    // Method to determine the winner
    public static String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "It's a tie!";
        }
        if ((playerMove.equals("rock") && computerMove.equals("scissors")) ||
                (playerMove.equals("paper") && computerMove.equals("rock")) ||
                (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "Player wins!";
        }
        return "Computer wins!";
    }
}
