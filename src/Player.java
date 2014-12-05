import java.io.*;
import java.util.*;
/**
 * [Description]
 * 
 * @author (Michael Arteaga, Joseph Carbone) 
 * @version (Oct 24, 2014)
 */
public class Player
{
	private String name;
	private int health = 5;
	private boolean completedMove;
	private Deck deck = new Deck();
	private ArrayList<Card> hand = new ArrayList<Card>();
	
	private List<MagicCard> magicDeck = new ArrayList<MagicCard>();
	private List<CreatureCard> monsterDeck = new ArrayList<CreatureCard>();
	private List<Card> currentHand = new ArrayList<Card>();
	

	public static void main(String args[]) {
		Player mike = new Player("Mike");
		
	}
	
	/**
	 * Constructor for objects of class Player
	 */
	public Player() {				// default constructor
		name = "[default]";	
	}
	public Player(String name) {	//constructor
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int loseAPoint(){
		return health--;
	}
	private Map<String, Card> getHand() {
		return hand.viewHand();
	}
	public boolean makesMove() {
		hand.pickCard();
		//picks a creature to put on board
		//picks a Magic card to use offensely
		//attacks
		//picks a magic card to put on board
		completedMove = true;
		return false;
	}
	

	/** @return The list of words generated
	 *  by the constructor.
	 */

	public List<CreatureCard> getMonsterDeck() {
		return monsterDeck;  
	}

	//public List<Card> getHand() {
	//	return currentHand; 
	//}

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

	/**
	 * The player's health
	 * @return health
	 */
	public int getHealth() {
		return health;
	}
}
