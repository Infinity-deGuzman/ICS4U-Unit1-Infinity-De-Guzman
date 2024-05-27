/**
 * The program lets you play
 * rock paper scissors
 *
 * By:      Infinity de Guzman
 * Version: 1.0
 * Since:   2024-05-27
 */

// don't forget to install readline-sync

import readlineSync from 'readline-sync'

type Move = 'rock' | 'paper' | 'scissors'

const moves: Move[] = ['rock', 'paper', 'scissors']

function getRandomMove(): Move {
    return moves[Math.floor(Math.random() * moves.length)]
}

function determineWinner(playerMove: Move, computerMove: Move): string {
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

function playGame(): void {
    let playerMove: Move

    while (true) {
        const input = readlineSync.question('Enter rock, paper, or scissors: ').toLowerCase()
        if (moves.includes(input as Move)) {
            playerMove = input as Move
            break
        } else {
            console.log('Invalid move. Please enter rock, paper, or scissors.')
        }
    }

    const computerMove = getRandomMove()
    console.log(`Player move: ${playerMove}`)
    console.log(`Computer move: ${computerMove}`)
    console.log(determineWinner(playerMove, computerMove))
}

// Start the game
playGame()
