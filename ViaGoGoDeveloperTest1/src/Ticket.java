import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Paul on 01/11/2017.
 * The Ticket Class represents the tickets for each event, each event Object will contain numerous tickets
 */
public class Ticket {

    /**
     * Declaring Ticket Class Instance Variables, as the price Variable represents currency it is of type BigDecimal
     */
    private BigDecimal price;
    private Random randomNum;
    private Double ticketPrice;

    /**
     * Ticket Constructor, which accepts no Parameters, price Variable is rounded down to two decimal points
     */
    public Ticket(){
        price = new BigDecimal(getRandomNumber()).setScale(2,BigDecimal.ROUND_HALF_EVEN);
    }

    /**
     * Accessor/Getter Method for price variable
     * @return the value the price Variable, is currently referencing
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This Method generates a random value, via the Random Object, to represent the price of each ticket
     * @return a double value between 1 & 500
     */
    public double getRandomNumber(){
        randomNum = new Random();
        ticketPrice = 1 + randomNum.nextDouble() * 500.00;
        return ticketPrice;
    }

}
