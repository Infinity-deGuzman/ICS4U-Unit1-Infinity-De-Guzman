/**
 * The program shows the energy based on kilograms inputted.
 *
 * By:  Infinity de Guzman
 * Version: 1.0
 * Since: 2024-02-22
 */

import {createPrompt} from 'bun-promptx'

const mass = createPrompt('Enter the mass of an object in kilograms: ')
const c = 2.998 * (10 ** 8)
let energy = mass * (c ** 2)

