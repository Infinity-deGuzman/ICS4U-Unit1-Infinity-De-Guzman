/**
 * The program lets you determine
 * what day of the week a date is.
 *
 * By:      Infinity de Guzman
 * Version: 1.0
 * Since:   2024-05-30
 */

import { createPrompt } from 'bun-promptx'

function dayOfWeek(year: number, month: number, day: number): string {
    const daysOfWeek = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    
    /**
     * Doomsday for each month (doomsdays of each year
     * are the same day of the week)
     */
    const doomsdayPerMonth: number[] = [3, 0, 0, 4, 9, 6, 11, 8, 5, 10, 7, 12];
    
    // Century anchor day
    const anchorDays: number[] = [2, 0, 5, 3];
    
    // Extracting last two digits of the year
    const yearLastTwoDigits = year % 100;
    
    // Finding the century and year within the century
    const century = Math.floor(year / 100);
    
    // Calculating the anchor day for the century
    const centuryAnchorDay = anchorDays[century % 4];
    
    // Calculating the doomsday for the year
    const yearDoomsday = ((yearLastTwoDigits + Math.floor(yearLastTwoDigits / 4)) % 7);
    
    // Finding the month's doomsday
    const monthDoomsday = doomsdayPerMonth[month - 1];
    
    // Finding the day of the week
    const dayOfWeekIndex = (day - monthDoomsday + yearDoomsday + centuryAnchorDay) % 7;
    
    return daysOfWeek[dayOfWeekIndex];
}


// Constants & Variables
const yearPrompt = createPrompt("Enter a year: ")
let year = parseFloat(yearPrompt.value)
const monthPrompt = createPrompt("Enter a month: ")
let month = parseFloat(monthPrompt.value)
const dayPrompt = createPrompt("Enter a day: ")
let day = parseFloat(dayPrompt.value)
console.log(`${year}-${month}-${day} is a ${dayOfWeek(year, month, day)}.`);

console.log('\nDone.')
