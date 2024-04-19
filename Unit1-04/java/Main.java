/*
 * This is a program creates a random number
 * that the user tries to guess
 *
 * @author  Infinity de Guzman
 * @version 1.0
 * @since   2024-04-28
 */

import java.util.Random;
import java.util.Scanner;

/**
* This is the standard "NumberGuessing" program.
*/
final class NumberGuess {

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this is ever called
    *
    * @throws IllegalStateException if this is ever called
    *
    */
    private NumberGuess() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(String[] args) {
        // constants & variables
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();
        final int randomNum = random.nextInt(8) + 1;
        final int randomNumMax = 8;
        final String invalidInputString =
            "cannot be counted as a guess.\n";
        int totalGuess = 0;
        int guessInt = 0;

        while (true) {
            // input and error check
            boolean validInput = false;
            try {
                System.out.print("Guess a number between 1 - 8: ");
                final String guessString = scanner.nextLine().trim();
                if (guessString.isEmpty()) {
                    System.out.println(invalidInputString);
                } else {
                    guessInt = Integer.parseInt(guessString);
                    if (guessInt < 1 || guessInt > randomNumMax) {
                        System.out.println(invalidInputString);
                    } else {
                        validInput = true;
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println(invalidInputString);
            }
            // process
            if (validInput) {
                totalGuess += 1;
                if (guessInt > randomNum) {
                    System.out.println("You guessed too high :( try again.\n");
                } else if (guessInt < randomNum) {
                    System.out.println("You guessed too low :( try again.\n");
                } else {
                    // output
                    System.out.println(
                        "Correct !!\nTotal guesses: " + totalGuess
                    );
                    break;
                }
            }
        }
        System.out.println("\nDone.");
    }
}

