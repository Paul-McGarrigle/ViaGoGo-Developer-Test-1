import java.awt.*;
import java.util.*;

/**
 * Created by Paul on 01/11/2017.
 * This Class represents the World, instantiating this Class will generate the application seed data & return the
 * 5 closest events to the location specified by the user
 */
public class World {

    /**
     * Declaring World Class Instance Variables, worldMin & worldMax refer to the size of the world events will be
     * generated in n order to increase the size of the world change these values
     */
    private ArrayList<Event> eventList = new ArrayList<>();
    private Set<Point> eventLocationSet = new HashSet<>();
    private ArrayList<Ticket> ticketList;
    private Point userLocation;
    private int manhattanDistance, worldMin = -10, worldMax = 21, numOfEvents, numOfTickets, newRandomNumber;
    private Random randomNum = new Random();

    /**
     * World Constructor, when this Constructor is invoked the generateSeedData Method is invoked
     * in order to start the process of generating random world data, including events & tickets etc.
     * @param userLocation a Point Object based on the user entered coordinates
     */
    public World(Point userLocation){
        this.userLocation = userLocation;
        generateSeedData();
    }

    /**
     * This Method generates a random number between 0 & 200, this will represent the number of events in the world,
     * and creates that number of event Objects, via a for loop, and adds them to an ArrayList of events
     * It then invokes the generateManhattanDistance Method to assign a Manhattan Distance and the printResults
     * Method to find and display the 5 closest events to the user location
     */
    public void generateSeedData(){
        numOfEvents = getRandomNumber(0, 200);
        System.out.println("Currently there are " + numOfEvents + " events worldwide");


        for(int i = 0; i <= numOfEvents; ++i){
            Event event = new Event(generateTicket(), generateUniqueLocation());
            eventList.add(event);
        }

        generateManhattanDistance();

        printResults();
    }

    /**
     * This Method creates a new Point Object based on random Integers within the world size and range.
     * If the point location does not already exist in the eventLocationSet HashSet it is added to the Set, however
     * if the location is already in the HashSet it means the location is already in use and the point is discarded
     * and the Method is called again recursively.  This is to ensure there is only one event at each location.  If
     * the application was scaled up to allow more than one event at each location, then the check and HashSet
     * eventLocationSet would be removed
     * @return a unique location point Object
     */
    public Point generateUniqueLocation(){
        Point eventLocation = new Point(getRandomNumber(worldMin, worldMax), getRandomNumber(worldMin, worldMax));

        if(!eventLocationSet.contains(eventLocation)) {
            eventLocationSet.add(eventLocation);
        } else {
            generateUniqueLocation();
        }

        return eventLocation;
    }

    /**
     * This Method generates a random number of tickets, between 0 & 5000, for each event Object,
     * and creates that number of ticket Objects, via a for loop, and adds them to an ArrayList of tickets
     * @return an ArrayList of Ticket Objects
     */
    public ArrayList<Ticket> generateTicket(){
        numOfTickets = getRandomNumber(0, 5000);
        ticketList = new ArrayList<>();

        for(int i = 0; i < numOfTickets; ++i){
            Ticket ticket = new Ticket();
            ticketList.add(ticket);
        }

        return ticketList;
    }

    /**
     * This Method generates the Manhattan Distance between each event location and the location specified by the user
     * This generated value is then set as the events Manhattan Distance via the Setter/Modifier Method
     * The ArrayList of events is then sorted in ascending order, based on the Manhattan Distance.  The
     * Collections.sort() Method knows to sort the ArrayList based on this criteria as it looks at the CompareTo
     * Overridden Method of the Comparable Interface in the Event Class
     */
    public void generateManhattanDistance(){
        for(Event event: eventList){

            manhattanDistance = Math.abs(userLocation.x - event.getEventLocation().x)
                    + Math.abs(userLocation.y - event.getEventLocation().y);

            event.setManhattanDistance(manhattanDistance);
        }

        Collections.sort(eventList);
    }

    /**
     * This Method will return a random integer based on a user specified range
     * @param min the minimum number in the range, in which the random number will be chosen from
     * @param max the maximum number in the range, in which the random number will be chosen from
     * @return a random Integer based on the specified range
     */
    public int getRandomNumber(int min, int max){
        newRandomNumber = min + randomNum.nextInt(max);
        return newRandomNumber;
    }

    /**
     * This Method returns the first 5 events with the shortest Manhattan Distance from the user specified location
     * For the chosen events it invokes their toString Method, in order to display the relevant information
     */
    public void printResults(){
        System.out.println("Closest Events to (" + userLocation.x + ", " + userLocation.y + "): ");

        for(int i = 0; i < 5; ++i){
            System.out.println(eventList.get(i).toString());
        }
    }
}
