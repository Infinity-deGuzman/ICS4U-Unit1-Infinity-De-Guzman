/*
 * This is a program creates a random number 
 * that the user tries to guess
 *
 * @author  Infinity de Guzman
 * @version 1.0
 * @since   2024-04-05
 */

import { createPrompt } from 'bun-promptx'

// constants & variables
const randomNum = Math.floor((Math.random() * 8) + 1)
let totalGuess = 0

while (1) {
  // input
  const userGuess = createPrompt("Guess a number between 1 - 8: ")
  const guessInt = parseInt(userGuess.value || "-1")
  // error check
  if (isNaN(guessInt) == true || guessInt < 1 || guessInt > 8) {
    console.log("Invalid input. (This won't count as a guess)\n")
  } else {
    // process
    totalGuess += 1
    if (guessInt > randomNum) {
      console.log(`You guessed too high :( try again.\n`)
    } else if (guessInt < randomNum) {
      console.log(`You guessed too low :( try again.\n`)
    } else {
      // output
      console.log(`Correct !!\nTotal guesses: ${totalGuess}`)
      break
    }
  }
}

console.log("\nDone.")

