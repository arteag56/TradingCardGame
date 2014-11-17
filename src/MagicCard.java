
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
    private boolean offense; //Magic type: Offense or Defense?

    /**
     * Constructor for objects of class MagicCard
     */
    public MagicCard() {
    	super();//default constructor -- must be changed
        cardName = super.getName();
        offense = false;
    }

    /**
     * Gets the power of the card
     */
    public String getMagicName() {
        return cardName;
    }
    public boolean isOffense() {
    	return offense;
    }
    
    public void changeType() {
    	if (offense) {
    		offense = false;
    	}
    	else {
    		offense = true;
    	}
    }
    
    public String getInfo() {
    	String result;
    	if (offense) {
    		result = "offense";
    	}
    	else {
    		result = "defense";
    	}
    	return result;
    }
    
    public String toString() {
        return super.toString() + 
        		"\n  Type: Enhancement" +
        		"\n  Action: Enhance " + getInfo();
    }
    
}
