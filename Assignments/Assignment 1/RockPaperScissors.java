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
final class RockPaperScissors {

    /**
     * Prevent unsupported operation.
     * Throw an exception UnsupportedOperationException
     * if this is ever called.
     *
     * @throws UnsupportedOperationException if this is ever called
     */
    private RockPaperScissors() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Enumeration representing the possible moves.
     */
    enum Move { ROCK, PAPER, SCISSORS }

    /**
     * Gets a random move for the computer.
     *
     * @return A randomly selected Move (ROCK, PAPER, or SCISSORS).
     */
    public static Move getRandomMove() {
        final Random random = new Random();
        return Move.values()[random.nextInt(Move.values().length)];
    }

    /**
     * Determines the winner between the player's move and the computer's move.
     *
     * @param playerMove   The move chosen by the player. Must be non-null.
     * @param computerMove The move chosen by the computer. Must be non-null.
     * @return A string indicating the result of the game.
     *
     */
    public static String determineWinner(Move playerMove, Move computerMove) {
        final String result;
        if (playerMove == computerMove) {
            result = "It's a tie!";
        } else if (playerMove == Move.ROCK && computerMove == Move.SCISSORS
            || playerMove == Move.PAPER && computerMove == Move.ROCK
            || playerMove == Move.SCISSORS && computerMove == Move.PAPER) {
            result = "Player wins!";
        } else {
            result = "Computer wins!";
        }
        return result;
    }

    /**
     * Runs the Rock-Paper-Scissors game, prompting the user for input and
     * displaying the result.
     */
    public static void playGame() {
        final Scanner scanner = new Scanner(System.in);
        final Move[] moves = Move.values();
        Move playerMove = null;

        while (true) {
            System.out.print("Enter rock, paper, or scissors: ");
            final String input = scanner.nextLine().toLowerCase();
            try {
                playerMove = Move.valueOf(input.toUpperCase());
                break;
            } catch (IllegalArgumentException ex) {
                System.out.println(
                    "Invalid move. Please enter rock, paper, or scissors."
                );
            }
        }

        final Move computerMove = getRandomMove();
        System.out.println("Player move: " + playerMove);
        System.out.println("Computer move: " + computerMove);
        System.out.println(determineWinner(playerMove, computerMove));
    }

    /**
     * The main method to start the Rock-Paper-Scissors game.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        playGame();
    }
}
