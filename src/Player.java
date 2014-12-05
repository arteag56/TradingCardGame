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
	//private boolean completedMove;
	private Deck deck = new Deck();
	private List<Card> currentHand = new ArrayList<Card>();
	private boolean playedMonster=false,playedMagic=false;


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
		while(currentHand.size()<5)
			draw();
		return currentHand;
	}
	
	public boolean completedMove() {
		return(playedMonster&&playedMagic);
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
	public Card draw(){
		Card result=deck.pickCard();
		currentHand.add(result);
		return result;}
	
	public Card remove(int key){
		Card result= currentHand.get(key);
		currentHand.remove(key);
		if(result instanceof CreatureCard)
			playedMonster=true;
		if(result instanceof MagicCard)
			playedMagic=true;
		return result;}
	
	public void newTurn(){
		playedMonster=false;
		playedMagic=false;}
	
	public boolean getPlayedMonster()
	{return playedMonster;}
	
	public boolean PlayedMagic()
	{return playedMagic;}
	

	
}
