import java.util.*;
/**
 * Class Player allows decks and hands to be created for specific players. 
 * It also keeps track of that players health. It also keeps track of if players have exhausted the cards 
 * they are allowed to play. 
 *
 * @author (Michael Arteaga, Joseph Carbone)
 * @version (Oct 24, 2014)
 */
public class Player{
	private String name;
	private int health = 5;
	private Deck deck;
	private List<Card> currentHand;
	private boolean playedMonster,playedMagic;


	/**
	 * Constructor for objects of class Player
	 */
	public Player() { 	// default constructor
		name = "[default]";
		deck= new Deck(true);
		playedMonster=false;
		playedMagic=false;
		currentHand = new ArrayList<Card>();
	}
	public Player(String name) { //constructor
		this.name = name;
		deck= new Deck(true);
		playedMonster=false;
		playedMagic=false;
		currentHand = new ArrayList<Card>();
	}
	
	public String getName() {		//Accessor Methods
		return name;
	}
	
	public int loseAPoint(){
		return health--;
	}
	public List<Card> getHand() { 	//returns the current hand (will always have 5 cards)
		while(currentHand.size()<5) {
			currentHand.add(draw());
		}
		return currentHand;
	}
	/**
	 * Tells the GameBoard whether or not this player completed their move.
	 * @return true if player already played a magic and monster card
	 */
	public boolean completedMove() {
		return (playedMonster&&playedMagic);
	}
	/** 
	 * Player holds a deck.
	 * @return Map
	 */

	private Map<String,Card> getDeck() {					
		return deck.getDeck();

	}
	
	public boolean playedTurn() {
		return false;
	}
	/**
	 * The player's health
	 * @return health
	 */
	public int getHealth() {
		return health;
	}
	
	private Card draw() {
		if (deck.getDeck().isEmpty()) {
			return null;
		}
		return deck.pickCard();
	}

//might need to change
	public Card remove(int key){
		Card result= currentHand.get(key);
		currentHand.remove(key);
		if(result instanceof CreatureCard)
			playedMonster=true;
		if(result instanceof MagicCard)
			playedMagic=true;
		return result;}
	
	public Card playCard(String name) { //test
		Card c = null;
		for (int i = 0; i < currentHand.size(); i++) {
			if (currentHand.get(i).equals("name")) {
				c = currentHand.get(i);
				currentHand.remove(i);
			}
		}
		if (c instanceof CreatureCard) {
			playedMonster = true;
		}
		else {
			playedMagic = true;
		}
		return c;
	}

	public Card remove(String name){
		for(int i=0;name!=currentHand.get(i).getName(); i++)
			if(name.equals(currentHand.get(i).getName())){
		Card result= currentHand.get(i);
		currentHand.remove(i);
		if(result instanceof CreatureCard)
			playedMonster=true;
		if(result instanceof MagicCard)
			playedMagic=true;
		return result;}
		return null;
		}
		
	public void newTurn(){
		playedMonster=false;
		playedMagic=false;}

	public boolean playedMonster()
	{return playedMonster;}

	public boolean playedMagic()
	{return playedMagic;}

	public static void main(String[] args)
	{
		Player p = new Player("Mike");
		System.out.println(p.getHand());
		System.out.println("////////");
		System.out.println(p.getHand().remove(0));
		System.out.println("/////////");
		System.out.println(p.getHand());
		
		
		
	}


}
