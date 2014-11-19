/**
 * This MagicCard class will enhance a CreatureCard's attack
 * or defense against another CreatureCard object.
 * 
 * @author (Michael Arteaga, Joseph Carbone, Peter Cipolone, Eric Oliver)
 * @version (Nov 19, 2014)
 */
public class MagicCard extends Card
{
    private int value;
    private String cardName;
    private boolean offense; //Magic type: is this card for offense?

    /**
     * Constructor for objects of class MagicCard
     */
    public MagicCard() {
    	super("[Default]", 50);
        offense = false;
    }
    
    public MagicCard(String name, int num, boolean isOffense) {
    	super(name, num);
    	offense = isOffense;
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
