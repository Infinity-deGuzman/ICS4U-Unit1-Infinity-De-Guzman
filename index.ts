/**
 * The program shows how to get input
 * and deal with numbers.
 *
 * By:      Infinity de Guzman
 * Version: 1.0
 * Since:   2024-02-15
 */

import { createPrompt } from 'bun-promptx'

const logLength = createPrompt('What is the length of your log? ')
const capacity = 1100
const weight = 20
const maxLength = capacity / weight



console.log(`Hey there ${String(name.value)}`)

const ageString = createPrompt('What is your age? ')

let ageNumber = parset(ageString.value)

ageNumber = ageNumber - 10

console.log(`Age is > ${ageNumber}`)


console.log('\nDone.')
