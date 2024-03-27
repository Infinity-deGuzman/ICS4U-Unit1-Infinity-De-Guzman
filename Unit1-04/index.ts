/**
 * This program generates a random number
 * for the player to guess.
 *
 * By: Infinity de Guzman
 * Version: 1.0
 * Since: 2024-02-27
 */

import {createSelection} from 'bun-promptx'

let counter = 0
const randomNumber = Math.floor(Math.random() * 6) + 1

while (true) {

