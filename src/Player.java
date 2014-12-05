import java.io.*;
import java.util.*;
/**
 * [Description]
 *
 * @author (Michael Arteaga, Joseph Carbone)
 * @version (Oct 24, 2014)
 */
public class Player{
	private String name;
	private int health = 5;
	private boolean completedMove;
	private Deck deck = new Deck();
	private List<Card> currentHand = new ArrayList<Card>();


	/**
	 * Constructor for objects of class Player
	 */
	public Player() { // default constructor
		name = "[default]";
	}
	public Player(String name) { //constructor
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int loseAPoint(){
		return health--;
	}
	public List<Card> getHand() {
		return currentHand;
	}
	public boolean makesMove() {
		//hand.pickCard();
		//picks a creature to put on board
		//picks a Magic card to use offensely
		//attacks
		//picks a magic card to put on board
		completedMove = true;
		return false;
	}
	/** @return The list of words generated
	 * by the constructor.
	 */

	public Map<String,Card> getDeck() {						//////////////
		return deck.getDeck();

	}
	/**
	 * The player's health
	 * @return health
	 */
	public int getHealth() {
		return health;
	}
}
