/*
 * This program takes the mass of an object
 * and calculates the energy released.
 *
 * @author  Infinity de Guzman
 * @version 1.0
 * @since   2024-03-07
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Energy calculation.
 */

final class EnergyCalculator {

    /**
     * Speed of light in m/s.
     */

    public static final int LIGHT = 299792458;

    /**
     * Prevent instantiation.
     * Throw an exception IllegalStateException
     * if this is ever called.
     *
     * @throws IllegalStateException if this is ever called
     */
    private EnergyCalculator() {
        throw new IllegalStateException("Error: can't instantiate.");
    }

    /**
     * Main method to run the energy calculator.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        try {
            final Scanner input = new Scanner(System.in);
            System.out.print("Enter the mass of an object in kilograms: ");
            final double mass = input.nextDouble();

            if (mass < 0) {
                System.out.println("invalid input. cannot be negative.");
                System.exit(0);

            }

            final double energy = mass * Math.pow(LIGHT, 2);
            System.out.println(mass + " kg of mass would produce "
                + String.format("%.3e", energy) + " J of energy.");
            input.close();
        } catch (InputMismatchException ex) {
            System.out.println("invalid input.");
        }

        System.out.println("\nDone.");
    }
}

