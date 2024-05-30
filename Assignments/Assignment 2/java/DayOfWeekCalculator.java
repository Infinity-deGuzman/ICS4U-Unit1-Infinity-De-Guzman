import java.util.Scanner;

/**
 * This program lets the user enter a date and
 * displays the day of the week for that date.
 *<p>
 * Author:  Infinity de Guzman
 * Version: 1.0
 * Since:   2024-05-30
 * </p>
 */
public final class DayOfWeekCalculator {

    // Constants for doomsdays and anchor days
    private static final int[] DOOMSDAY_PER_MONTH = {3, 0, 0, 4, 9, 6, 11, 8, 5, 10, 7, 12};
    private static final int[] ANCHOR_DAYS = {2, 0, 5, 3};
    private static final String[] DAYS_OF_WEEK = {
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        };

    // Constant indices and other values
    private static final int DAYS_IN_WEEK = 7;
    private static final int CENTURY_ANCHOR_MOD = 4;
    private static final int BASE_YEAR_DIVISOR = 100;
    private static final int FOUR_YEARS_DIVISOR = 4;

    /**
     * Returns the day of the week for a given date.
     *
     * @param year  The year of the date.
     * @param month The month of the date.
     * @param day   The day of the date.
     * @return The day of the week for the given date.
     */
    public static String dayOfWeek(int year, int month, int day) {
        int yearLastTwoDigits = year % 100;
        int century = year / BASE_YEAR_DIVISOR;
        int centuryAnchorDay = ANCHOR_DAYS[century % CENTURY_ANCHOR_MOD];
        int yearDoomsday = (yearLastTwoDigits + (yearLastTwoDigits / FOUR_YEARS_DIVISOR)) % DAYS_IN_WEEK;
        int monthDoomsday = DOOMSDAY_PER_MONTH[month - 1];
        int dayOfWeekIndex = (day - monthDoomsday + yearDoomsday + centuryAnchorDay) % DAYS_IN_WEEK;

        return DAYS_OF_WEEK[dayOfWeekIndex];
    }

    /**
     * Gets an integer input from the user.
     *
     * @param scanner    The scanner to read input from.
     * @param promptText The text to prompt the user with.
     * @return The integer input from the user.
     */
    public static int getInput(Scanner scanner, String promptText) {
        int value = -1;
        do {
            System.out.print(promptText);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value < 0) {
                    System.out.println("Invalid input. Please enter a non-negative number.");
                    value = -1;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        } while (value < 0);
        return value;
    }

    /**
     * Main method to run the day of the week calculator.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int year = getInput(scanner, "Enter a year: ");
            int month = getInput(scanner, "Enter a month: ");
            int day = getInput(scanner, "Enter a day: ");

            System.out.println(year + "-" + month + "-" + day + " is a " + dayOfWeek(year, month, day) + ".");
            System.out.println("\nDone.");
        }
    }
}
