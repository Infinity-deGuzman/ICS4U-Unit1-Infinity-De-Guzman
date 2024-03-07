/* This program checks for a runtime error
*
* @author  Infinity de Guzman
* @version 1.0
* @since   2024-03-07
*/

import java.util.scanner;

public class Main {
        public static void main(String[] args) {
        // this function checks for runtime error
        //
        // create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // input
        System.out.print("Enter the mass of an object in kilograms: ");
        String massAsString = scanner.nextLine();

        // process & output
        try {
                int massAsNumber = Integer.parseInt(massAsString);
                const light = 2.998e8
                const energy = massAsString * (Math.pow(light, 2))

                System.out.printf("%d.%n kg of mass would produce", massAsNumber);
        } catch (NumberFormatException e) {
                 System.out.printf("invalid input.");
        }

        // close the Scanner object
        scanner.close();
        System.out.println("\nDone.");
        }
}
