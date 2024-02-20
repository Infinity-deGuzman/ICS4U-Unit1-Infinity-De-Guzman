/**
 * The program shows how to get input
 * and deal with numbers.
 *
 * By:      Infinity de Guzman
 * Version: 1.0
 * Since:   2024-02-15
 */

import { createPrompt } from 'bun-promptx'

const logLength = createPrompt('What is the length of your log in meters? (0.25, 0.5, 1): ')
let logLengthFloat = parseFloat(logLength.value)
const capacity = 1100
const weight = 20
let maxLength = capacity / weight
let numberOfLogs = maxLength / logLengthFloat

console.log(`Hey there ${numberOfLogs.value}`)


console.log('\nDone.')
