import java.awt.*;
import java.util.Scanner;

/**
 * Created by Paul on 01/11/2017.
 * The Driver Class contains the main Method & therefore executes the application
 */
public class Driver {
    /**
     * Declaring variables which specify the size of the world, in order to
     * increase the size of the world change these values
     */
    private static final int worldSizeMin = -10;
    private static final int worldRangeMax = 20;

    /**
     * The main Method invokes the getUserInteraction Method in order to start the application
     * @param args holds reference to any command line arguments
     */
    public static void main(String[] args){
        getUserInteraction();
    }

    /**
     * This Method interacts with the user and gathers their input via the Scanner Object
     * The user is prompted to enter the coordinates of their location, separated by a comma
     * These coordinates are split into the String Array longLat & used for the x & y axises on a Point Object
     * The Point Object is then passed as a Parameter, to the World Class Constructor to instantiate an instance
     * of the World Class, should the user enter a range outside the world an Illegal Argument Exception will be
     * thrown and if the user enters coordinates without a comma a Number Format Exception will be thrown.
     * Both these exceptions will be caught, and handled with error messages without crashing the application
     */
    public static void getUserInteraction(){
        boolean validInput = false;
        while(!validInput) {
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Please Input Coordinates");

                String userInput = scanner.nextLine();
                String[] longLat = userInput.split(",");

                int userCoordinateX = Integer.parseInt(longLat[0]);
                int userCoordinateY = Integer.parseInt(longLat[1]);

                if(userCoordinateX < worldSizeMin || userCoordinateX > (worldSizeMin + worldRangeMax)
                        || userCoordinateY < worldSizeMin || userCoordinateY > (worldSizeMin + worldRangeMax)){
                    throw new IllegalArgumentException();
                }

                Point userLocation = new Point(userCoordinateX, userCoordinateY);
                World world = new World(userLocation);

                scanner.close();

                validInput = true;

            } catch (NumberFormatException exception) {
                System.out.println("Invalid input, please enter coordinates in the format of 1,1 etc.");
            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid input, please keep coordinates within -10 to 10 on both X & Y axises");
            }
        }

    }
}