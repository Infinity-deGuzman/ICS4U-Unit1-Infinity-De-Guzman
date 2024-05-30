/*
 * This program lets the user enter a date and
 * displays the day of the week for that date.
 *
 * Author:  Infinity de Guzman
 * Version: 1.0
 * Since:   2024-05-30
 */

import java.util.Scanner;

/**
 * A class that allows the user to know the day of the week of a date.
 * <p>
 * Author:  Infinity
 * Version: 1.0
 * Since:   2024-05-30
 * </p>
 */

public class DayOfWeekCalculator {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter year, month, and day
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        System.out.print("Enter a month: ");
        int month = scanner.nextInt();

        System.out.print("Enter a day: ");
        int day = scanner.nextInt();

        // Calculate and display the day of the week
        System.out.println(year + "-" + month + "-" + day + " is a " + dayOfWeek(year, month, day) + ".");

        // Close the scanner
        scanner.close();
    }

    public static String dayOfWeek(int year, int month, int day) {
        // Array to store names of days of the week
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // Doomsday for each month
        int[] doomsdayPerMonth = {3, 0, 0, 4, 9, 6, 11, 8, 5, 10, 7, 12};

        // Century anchor day
        int[] anchorDays = {2, 0, 5, 3};

        // Extracting last two digits of the year
        int yearLastTwoDigits = year % 100;

        // Finding the century and year within the century
        int century = year / 100;

        // Calculating the anchor day for the century
        int centuryAnchorDay = anchorDays[century % 4];

        // Calculating the doomsday for the year
        int yearDoomsday = (yearLastTwoDigits + (yearLastTwoDigits / 4)) % 7;

        // Finding the month's doomsday
        int monthDoomsday = doomsdayPerMonth[month - 1];

        // Finding the day of the week
        int dayOfWeekIndex = (day - monthDoomsday + yearDoomsday + centuryAnchorDay) % 7;

        // Return the day of the week
        return daysOfWeek[dayOfWeekIndex];
    }
}
