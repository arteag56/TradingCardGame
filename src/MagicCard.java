
/**
 * [Description]
 * 
 * @author (Michael Arteaga, [add names]) 
 * @version (Oct 1, 2014)
 */
public class MagicCard extends Card
{
    private int value;
    private String cardName;

    /**
     * Constructor for objects of class MagicCard
     */
    public MagicCard() {
        cardName = super.getName();
    }

    /**
     * Gets the power of the card
     */
    public String getMagicName() {
        return cardName;
    }
    
    public String toString() {
        return super.toString() +
                "Type: Enhancement";
    }
    
}
