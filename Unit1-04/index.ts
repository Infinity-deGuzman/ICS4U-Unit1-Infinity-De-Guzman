/**
 * This program generates a random number
 * for the player to guess.
 *
 * By: Infinity de Guzman
 * Version: 1.0
 * Since: 2024-02-27
 */

import {createSelection} from 'bun-promptx'

// variables
const randomNumber = Math.floor(Math.random() * 6) + 1
let guessTotal = 0


while (1) {
    // input
    const guess = createPrompt("Choose a number between 1 and 6: ")
    const guessInt = parseInt(guess.value || "-1")
    // error if guess cannot be classified as a pos. integer,
    // or not within parameters
    if (isNaN(guessInt) == true || guessInt < 1 || userGuessInt > 6) {
        console.log("Invalid input. Try again.\n")
    } else {
        // process
        guessTotal += 1
        if (guessInt > randomNumber) {
            console.log(`You guessed too high, try again!\n`)
        } else if (guessInt < randomNumber) {
            console.log(`You guessed too low, try again!\n`)
        } else {
            // output
            console.log(`Congrats! You got it in ${guessTotal} tries :)`)
            break
        }
    }
}

console.log("\nDone.")
