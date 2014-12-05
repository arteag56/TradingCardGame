/**
 * This MagicCard class will enhance a CreatureCard's attack
 * or defend against another CreatureCard object's attack.
 * 
 * @author (Michael Arteaga, Joseph Carbone, Peter Cipolone, Eric Oliver)
 * @version (Dec 5, 2014)
 */
public class MagicCard extends Card
{
    private boolean offense; //Magic type: is this card for offense?

    public MagicCard() {			//default constructor
    	super(50, "[Default]");
        offense = false;
    }
    
    public MagicCard(int num, String name, boolean isOffense) { //custom constructor
    	super(num, name);
    	offense = isOffense;
    }
    
    public boolean isOffense() { 		//Accessors methods
    	return offense;
    }

    public String getEnhanceType() { 
    	String result;
    	if (offense) {
    		result = "offense";
    	}
    	else {
    		result = "defense";
    	}
    	return result;
    }
    
    private void changeType() { 	//used for testing
    	if (offense) {
    		offense = false;
    	}
    	else {
    		offense = true;
    	}
    }
    
    public String toString() {
        return super.toString() + 
        		"\n  Type: Enhancement" +
        		"\n  Action: Enhance " + getEnhanceType();
    }
}//Class MagicCard