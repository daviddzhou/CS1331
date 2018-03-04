import java.util.Scanner;
import java.util.LinkedList;

/**
 * This class is the driver for the Planetary System homework.
 * After creating the other classes and implementing all the methods,
 * you should be able to run this file and test the simulation.
 *
 * There is code in this file that you haven't seen before.
 * Don't worry, you don't need to understand how this works!
 * This is just to give you a simulation so you can run and test your code.
 *
 * @author Karen Taub
 * @version 1.0
 */
public class PlanetarySystemSim {


    // ***************************************************
    // ****          DO NOT MODIFY THIS FILE          ****
    // ***************************************************

    /**
     * Creates a new Planetary System instance, populates it with a sun and two planets,
     * and leaves it free for student modification.
     *
     * @param args command line input
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create system and add a star and planets
        PlanetarySystem system = new PlanetarySystem();
        Star sun = new Star("Sun", 2);
        Planet earth = new RockyPlanet("Earth", 332, 1, true);
        Planet jupiter = new GasGiant("Jupiter", 1000, 11, 3);
        system.changeStar(sun, input);
        system.addPlanet(earth);
        system.addPlanet(jupiter);

        System.out.println();
        System.out.println("Welcome to the Planetary System simulator v1.0!");
        System.out.println("Please enter a name for your new planetary system!");
        system.setName(input.nextLine());

        run(input, system);
    }


    /**
     * Displays tbe list of options a user can take while interacting with the
     * simulation.
     *
     * @param system the system to interact with
     * @param input the Scanner object to take in additional user input
     */
    private static void run(Scanner input, PlanetarySystem system) {
        boolean isPlaying = true;
        while (isPlaying) {
            System.out.println();
            System.out.println("Which action would you like to take?");
            System.out.println("0. View your system's current status");
            System.out.println("1. Add a planet");
            System.out.println("2. Make a planet orbit");
            System.out.println("3. Change the star");
            System.out.println("4. Exit\n");

            int userInput = input.nextInt();
            input.nextLine();
            System.out.println();

            if (userInput == 0) {
                system.printSystem();
                System.out.println();
            } else if (userInput == 1) {
                addPlanet(system, userInput, input);
            } else if (userInput == 2) {
                orbitPlanet(system, userInput, input);
            } else if (userInput == 3) {
                changeTheStar(system, userInput, input);
            } else if (userInput == 4) {
                System.out.println("Bye!");
                isPlaying = false;
            }
        }
    }


    /**
     * Allows a user to create a planet and adds it to the system.
     *
     * @param system the system to add a planet to
     * @param userInput the user's previous input
     * @param input the Scanner object to take in additional user input
     */
    private static void addPlanet(PlanetarySystem system, int userInput, Scanner input) {
        System.out.println("Which type of planet would you like "
            + "to add?");
        System.out.println("0. Rocky Planet");
        System.out.println("1. Gas Giant");
        System.out.println("2. Another planet type");
        System.out.println();

        userInput = input.nextInt();
        input.nextLine();
        System.out.println();

        if (userInput == 0) {   // Rocky Planet
            System.out.println("Please enter its name.");
            String name = input.nextLine();
            System.out.println();
            System.out.println("Please enter its radius as a double.");
            double rad = input.nextDouble();
            input.nextLine();
            System.out.println();
            System.out.println("Please enter how many orbits it has completed as an int.");
            int orbits = input.nextInt();
            input.nextLine();
            System.out.println();
            System.out.println("Please enter whether it have life (y/n).");
            boolean canHaveLife =
                input.nextLine().trim().charAt(0) == 'y'
                ? true : false;
            System.out.println();

            system.addPlanet(new RockyPlanet(name, rad, orbits, canHaveLife));
        } else if (userInput == 1) {   // Gas Giant
            System.out.println("Please enter its name.");
            String name = input.nextLine();
            System.out.println();
            System.out.println("Please enter its radius as a double.");
            double rad = input.nextDouble();
            input.nextLine();
            System.out.println();
            System.out.println("Please enter how many orbits it has completed as an int.");
            int orbits = input.nextInt();
            input.nextLine();
            System.out.println();
            System.out.println("Please enter how many anticyclonic storms it has.");
            int storms = input.nextInt();
            input.nextLine();
            System.out.println();

            system.addPlanet(new GasGiant(name, rad, orbits, storms));
        } else if (userInput == 2) {   // Good ol' planet
            System.out.println("Please enter its name.");
            String name = input.nextLine();
            System.out.println();
            System.out.println("Please enter its radius as a double.");
            double rad = input.nextDouble();
            input.nextLine();
            System.out.println();
            System.out.println("Please enter how many orbits it has completed as an int.");
            int orbits = input.nextInt();
            input.nextLine();
            System.out.println();

            system.addPlanet(new Planet(name, rad, orbits));
        }
    }

    /**
     * Allows a user to pick a planet and have it complete an orbit around the star.
     *
     * @param system the system that has the planet to orbit
     * @param userInput the user's previous input
     * @param input the Scanner object to take in additional user input
     */
    private static void orbitPlanet(PlanetarySystem system, int userInput, Scanner input) {
        System.out.println("Which planet would you like to orbit?");
        system.listPlanets();

        userInput = input.nextInt();
        input.nextLine();
        system.getPlanetAtIndex(userInput).orbit();

    }

    /**
     * Allows the user to create a new star and have it become the new center of the planetary system.
     * @param system the system whose star we want to change
     * @param userInput the user's previous input
     * @param input the Scanner object to take in additional user input
     */
    private static void changeTheStar(PlanetarySystem system, int userInput, Scanner input) {


        System.out.println("Please the new star's name.");
        String name = input.nextLine();
        System.out.println();
        System.out.println("Which color would you like it to be?");
        int id = input.nextInt();
        input.nextLine();

        system.changeStar(new Star(name, id), input);

    }
}
