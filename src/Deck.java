import java.util.*;



/**
 * @author Joe Carbone
 *
 */
public class Deck {
	
	public HashMap <Integer, Set <String>>  deck, deck2;

	  public HashMap<Integer, Set<String>> monsterDeck()
	  {  return deck = new HashMap <Integer, Set <String>> ();  }
	  
	  public HashMap<Integer, Set<String>> magicDeck(){
		  return deck2= new HashMap <Integer, Set<String>>();
	  }

	  /** Associate the given alias with the given card */
	  public int addMonster (int cardNumber, Set <String> card)
	  // Add this entry to the map
	  { 
	      deck.put(cardNumber,card);
	      
	      return cardNumber;
	    }
	  
	  public int addMagic(int cardNumber, Set <String> card)
	  {deck2.put(cardNumber,card);
	  return cardNumber;
	  
	  }

}
