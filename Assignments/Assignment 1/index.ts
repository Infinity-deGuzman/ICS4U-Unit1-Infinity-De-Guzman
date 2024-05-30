/**
 * The program lets you play
 * rock paper scissors
 *
 * By:      Infinity de Guzman
 * Version: 1.0
 * Since:   2024-05-27
 */

// don't forget to install prompt-sync
const prompt = require('prompt-sync')()

const moves = ['rock', 'paper', 'scissors']

function getRandomMove() {
    return moves[Math.floor(Math.random() * moves.length)]
}

function determineWinner(playerMove, computerMove) {
    if (playerMove === computerMove) {
        return "It's a tie!"
    }
    if (
        (playerMove === 'rock' && computerMove === 'scissors') ||
        (playerMove === 'paper' && computerMove === 'rock') ||
        (playerMove === 'scissors' && computerMove === 'paper')
    ) {
        return 'Player wins!'
    }
    return 'Computer wins!'
}


let playerMove

while (true) {
    const input = prompt('Enter rock, paper, or scissors: ').toLowerCase()
    if (moves.includes(input)) {
        playerMove = input
        break
    } else {
        console.log('Invalid move. Please enter rock, paper, or scissors.')
    }
}

const computerMove = getRandomMove()
console.log(`Player move: ${playerMove}`)
console.log(`Computer move: ${computerMove}`)
console.log(determineWinner(playerMove, computerMove))
