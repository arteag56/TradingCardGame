import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * [Description]
 * 
 * @author (Michael Arteaga, Joseph Carbone) 
 * @version (Oct 24, 2014)
 */
public class Player
{
	Deck deck = new Deck();
	String name;
	List<MagicCard> magicDeck = new ArrayList<MagicCard>();
	List<CreatureCard> monsterDeck = new ArrayList<CreatureCard>();
	List<Card> currentHand = new ArrayList<Card>();

	/**
	 * Constructor for objects of class Player
	 */
	public Player() {
		name = "Peter";
	}
	public Player(String name) {
		this.name = name;
	}

	public static void main(String args[]) {

	}
	public String getName() {
		return name;
	}

	/** @return The list of words generated
	 *  by the constructor.
	 */

	public List<CreatureCard> getMonsterDeck() {
		return monsterDeck;  
	}

	public List<Card> getHand() {
		return currentHand; 
	}

	public List<Card> getDeck() {
		List<Card> deck = new ArrayList<Card>();
		for (Card s: monsterDeck) {
			deck.add(s);
		}

		for (Card s: magicDeck) {
			deck.add(s);
		}
		return deck;
	}
}
