/**
 * This program checks for a runtime error
 *
 * @author  Infinity de Guzman
 * @version 1.0
 * @since   2024-03-07
 */

import java.util.InputMismatchException;
import java.util.Scanner; 

final class EnergyCalculator {

    /* Speed of light in m/s */
    public static final double LIGHT = 2.998e8;

    private EnergyCalculator() {
        // makes things static
        throw new IllegalStateException("Error: can't instantiate.");
    }

/**
 * Main method to run the energy calculator.
 *
 * @param args command-line arguments
 */
    public static void main(final String[] args) {
        // Input
        try {
            final Scanner input = new Scanner(System.in);
            System.out.print("Enter the mass of an object in kilograms: ");
            final double mass = input.nextDouble();
            input.close();

            // Process & Output
            final double energy = mass * Math.pow(LIGHT, 2);
            if (mass < 0) {
                System.out.println("invalid input. cannot be negative.");
                System.exit(0);

            } else {
                System.out.printf(
                    "%.2f kg of mass would produce %.2e J of energy.%n",
                    mass,
                    energy);
            }
        } catch (InputMismatchException error) {
            System.out.println("invalid input.");
        }

        System.out.println("\nDone.");
    }
}
