import java.util.Scanner;

/**
 * This program lets the user enter a date and
 * displays the day of the week for that date.
 * <p>
 * Author:  Infinity de Guzman
 * Version: 1.0
 * Since:   2024-05-30
 * </p>
 */

final class DayOfWeekCalculator {

    /**
     * Array containing the names of the days of the week.
     */
    private static final String[] DAYS_OF_WEEK = {
        "Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday",
    };

    /**
     * Array containing the anchor days for each month.
     */
    private static final int[] ANCHOR_DAYS = {2, 0, 5, 3};

    /**
     * Array containing the doomsday constant
     * for each month for day of the week calculation.
     * The index corresponds to the month,
     * starting from January (index 0).
     * For example, index 0 corresponds to January,
     * index 1 to February, and so on.
     */
    private static final int[] DOOMSDAY_PER_MONTH = {
        3, 0, 0, 4, 9, 6, 11, 8, 5, 10, 7, 12,
    };

    /**
     * Dash separator used for formatting output in day of the week calculation.
     */
    private static final String DASH_SEPARATOR = "-";

    /**
     * Number of days in a week.
     */
    private static final int DAYS_IN_WEEK = 7;

    /**
     * Modulus for century anchor day calculation.
     */
    private static final int CENTURY_ANCHOR_MOD = 4;

    /**
     * Base year divisor for day of the week calculation.
     */
    private static final int BASE_YEAR_DIVISOR = 100;

    /**
     * Four years divisor for day of the week calculation.
     */
    private static final int FOUR_YEARS_DIVISOR = 4;

    /**
     * Prevent instantiation.
     * Throw an exception AssertionError
     * if this is ever called.
     *
     * @throws AssertionError if this is ever called
     */
    private DayOfWeekCalculator() {
        /*
        * Prevent instantiation.
        */
        throw new AssertionError("DayOfWeekCalculator cannot be instantiated");
    }

    /**
     * Returns the day of the week for a given date.
     *
     * @param year  The year of the date.
     * @param month The month of the date.
     * @param day   The day of the date.
     * @return The day of the week for the given date.
     */
    public static String dayOfWeek(int year, int month, int day) {
        final int yearLastTwoDigits = year % BASE_YEAR_DIVISOR;
        final int century = year / BASE_YEAR_DIVISOR;
        final int centuryAnchorDay = ANCHOR_DAYS[century % CENTURY_ANCHOR_MOD];
        final int yearDoomsday = (yearLastTwoDigits
            + (yearLastTwoDigits / FOUR_YEARS_DIVISOR)) % DAYS_IN_WEEK;
        final int monthDoomsday = DOOMSDAY_PER_MONTH[month - 1];
        final int dayOfWeekIndex = (day - monthDoomsday
            + yearDoomsday + centuryAnchorDay) % DAYS_IN_WEEK;

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
                    System.out.println(
                        "Please enter a non-negative number.");
                    value = -1;
                }
            } else {
                System.out.println(
                    "Please enter a valid number.");
                scanner.next();
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
            final int year = getInput(scanner, "Enter a year: ");
            final int month = getInput(scanner, "Enter a month: ");
            final int day = getInput(scanner, "Enter a day: ");

            System.out.println(year + DASH_SEPARATOR + month
                + DASH_SEPARATOR + day + " is a "
                + dayOfWeek(year, month, day) + ".");

            System.out.println("\nDone.");
        }
    }
}
