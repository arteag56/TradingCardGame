package deck;
import java.util.*;

/**
 * @author Joe Carbone
 *
 */
public class ThoughtMonsters  {
	private Map <String, Set <String>>  deck;

	  public Map<String, Set<String>> monsterDeck()
	  {  return deck = new HashMap <String, Set <String>> ();  }

	  /** Associate the given alias with the given people */
	  public void add (String cardNumber, Set <String> card)
	  // Add this entry to the map
	  { 
	      deck.put(cardNumber,card);
	    }

	  
	 /* *//** @return All the cards corresponding to
	   * the given cardNumber, in a Set.
	   *//*
	  public Set <String> expandNumber (String cardNumber)
	  {   
	     book.get(cardNumber);
	     if(!(book.get(cardNumber)).contains(Integer))
	        return book.get(cardNumber);
	     if (!(book.size()>0))
	        return book.get(cardNumber);
	     if(!(
	    		 return expandNumber(cardNumber);}*/
	     
	  
	    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThoughtMonsters t = new ThoughtMonsters();

	}

}
