/**
 * This program takes the mass of an object
 * and calculates the energy released.
 *
 * @author  Infinity de Guzman
 * @version 1.0
 * @since   2024-03-07
 */

import java.util.InputMismatchException;
import java.util.Scanner; 

final class EnergyCalculator {

    /* Speed of light in m/s */
    public static final int LIGHT = 299792458;

    private EnergyCalculator() {
        throw new IllegalStateException("Error: can't instantiate.");
    }

    public static void main(final String[] args) {
        try {
            final Scanner input = new Scanner(System.in);
            System.out.print("Enter the mass of an object in kilograms: ");
            final double mass = input.nextDouble();

            if (mass < 0) {
                System.out.println("invalid input. cannot be negative.");
                System.exit(0); // Exit the program

            }

            final double energy = mass * Math.pow(LIGHT, 2);
                System.out.println(mass + " kg of mass would produce "
                    + String.format("%.2e", energy) + " J of energy.");
                input.close();
            }
        } catch (InputMismatchException ex) {
            System.out.println("invalid input.");
        }

        System.out.println("\nDone.");
    }
}

