/*
 * This program lets
 * the user play rock, paper, scissors
 *
 * @author  Infinity de Guzman
 * @version 1.0
 * @since   2024-05-27
 */

import java.util.Scanner;
import java.util.Random;

final class RockPaperScissors {
    
    enum Move { ROCK, PAPER, SCISSORS }

    public static Move getRandomMove() {
        Random random = new Random();
        return Move.values()[random.nextInt(Move.values().length)];
    }

    public static String determineWinner(Move playerMove, Move computerMove) {
        if (playerMove == computerMove) {
            return "It's a tie!";
        }
        if ((playerMove == Move.ROCK && computerMove == Move.SCISSORS) ||
            (playerMove == Move.PAPER && computerMove == Move.ROCK) ||
            (playerMove == Move.SCISSORS && computerMove == Move.PAPER)) {
            return "Player wins!";
        }
        return "Computer wins!";
    }

    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        Move[] moves = Move.values();
        Move playerMove;

        while (true) {
            System.out.print("Enter rock, paper, or scissors: ");
            String input = scanner.nextLine().toLowerCase();
            try {
                playerMove = Move.valueOf(input.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move. Please enter rock, paper, or scissors.");
            }
        }

        Move computerMove = getRandomMove();
        System.out.println("Player move: " + playerMove);
        System.out.println("Computer move: " + computerMove);
        System.out.println(determineWinner(playerMove, computerMove));
    }

    public static void main(String[] args) {
        playGame();
    }
}
