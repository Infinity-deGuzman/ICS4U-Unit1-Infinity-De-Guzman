/**
 * The program shows the energy based on kilograms inputted.
 *
 * By:  Infinity de Guzman
 * Version: 1.0
 * Since: 2024-02-22
 */

import {createPrompt} from 'bun-promptx'

// input
const mass = createPrompt('Enter the mass of an object in kilograms: ')
const light = 2.998e8

// process & output
const massFloat = parseFloat(mass.value || "-1")
let energy = massFloat * (light ** 2)

if (isNaN(massFloat) || massFloat < 0) {
  console.log("Invalid input.")
} else {
  console.log(`${massFloat} kg of mass would produce ${energy.toExponential(3)} of energy.`)
}

console.log("\nDone.")

