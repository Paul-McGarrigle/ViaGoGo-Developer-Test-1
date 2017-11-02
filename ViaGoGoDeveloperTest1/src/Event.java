import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by Paul on 01/11/2017.
 * The Event Class represents the events contained in the world, a World Object will contain multiple event Objects
 * The Class implements the Comparable Interface in order to Override the compareTo Method so the Collections.sort()
 * Method can be applied to Collections of this Event Class
 */
public class Event implements Comparable{

    /**
     * Declaring Event Class Instance Variables
     */
    private int eventID = 0, manhattanDistance = 0, compareManhattanDistance;
    private static int count = 1;
    private ArrayList<Ticket> ticketList = new ArrayList<>();
    private Point eventLocation;
    private BigDecimal cheapestPrice;

    /**
     * Event Constructor
     * @param ticketList an ArrayList of Ticket Objects which represents tickets available for the event
     * @param eventLocation a Point Object which represents the location of the event
     */
    public Event(ArrayList<Ticket> ticketList, Point eventLocation) {
        this.eventID = count++;
        this.ticketList = ticketList;
        this.eventLocation = eventLocation;
    }

    /**
     * Various Getter (Accessor) & Setter (Mutator) Methods
     * @return Instance Variable reference values
     */
    public int getManhattanDistance() {
        return manhattanDistance;
    }

    public void setManhattanDistance(int manhattanDistance) {
        this.manhattanDistance = manhattanDistance;
    }

    public Point getEventLocation() {
        return eventLocation;
    }

    /**
     * This Method finds the cheapest ticket associated with the specified event
     * @return the value of the lowest ticket price BigDecimal value
     */
    public BigDecimal getCheapestTicketPrice(){
        cheapestPrice = ticketList.get(0).getPrice();
        for(Ticket price: ticketList){
            cheapestPrice = price.getPrice().min(cheapestPrice);
        }
        return cheapestPrice;
    }

    /**
     * This Method is Overridden from the Comparable Interface so the Collections.sort() Method can be
     * applied to Collections of the Event Class, it ensures collections of events will be sorted in
     * ascending order based on the Manhattan Distance of the event from the users location
     * @param event represents instances of the Event Class
     * @return a sorted list of events, in ascending order based on the Manhattan Distance value
     */
    @Override
    public int compareTo(Object event) {
        compareManhattanDistance = ((Event)event).getManhattanDistance();
        return this.manhattanDistance - compareManhattanDistance;
    }

    /**
     * This Method will display String information about the current event Object
     * @return a String with information on the specific event
     */
    @Override
    public String toString() {
        return "Event " + eventID + " - $" + getCheapestTicketPrice() + ", Distance " + manhattanDistance;
    }

}
