import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Deck object holds a Map of Card with each having a unique key. Deck can draw a card,
 * remove a card, return elements in the deck assuming it read the input from a file.
 * 
 * @author (Michael Arteaga, Joseph Carbone, Peter Cipolone, Eric Oliver)
 * @version (Dec 5, 2014)
 *
 */
public class Deck {
	private Map<String, Card> deck = new TreeMap<String, Card>();

	public Deck(boolean fillDeck) {
		if (fillDeck) {
			createDeck();
		}
	}
	/**
	 * Obtain the name of the file and open the file for reading. Attempt to
	 * recover from the typical I/O exceptions with a limited number of retries
	 * (3).
	 */
	public static Scanner openFile() {
		String nameOfFile;
		Scanner scan = null;
		boolean success = false;
		int attempt = 3;

		while (attempt > 0 && !success) {

			System.out.println("Enter Name of File: ");
			Scanner inputRead = new Scanner(System.in);
			nameOfFile = inputRead.next();

			try {
				scan = new Scanner(new File(nameOfFile));
				success = true;
				System.out.println("\n" + nameOfFile
						+ " was read successfully!");
			} catch (IOException e) {
				System.out.println(e.getMessage() + "\n");
				attempt--;
				if (attempt > 0) {
					System.out.println(attempt + " attempts left.");
				} else {
					System.out.println("You failure.");
				}

			}
			
		}// while loop
		return scan;
	}

	/**
	 * Fills the deck with card of both Creature and Magic.
	 */
	public void createDeck() {
		ArrayList<String> list = new ArrayList<String>();
		Scanner scan = openFile();
		scan.useDelimiter(",");
		while (scan.hasNext()) {
			list.add(scan.next());

			if (list.size() == 7 && list.get(0).trim().equals("C")) {
				boolean rare = false;
				if (list.get(6).trim().toLowerCase().equals("true")) {
					rare = true;
				}
				CreatureCard c = new CreatureCard(
						Integer.parseInt(list.get(1).trim()), list.get(2),
						Integer.parseInt(list.get(3).trim()), Integer.parseInt(list.get(4).trim()), 
						list.get(5).trim(), rare);
				deck.put(list.get(0).trim() + c.getCardNum(), c);
				list.clear();
			}
			if (list.size() == 4 && list.get(0).trim().equals("M")) {
				boolean isOffence = false;
				if (list.get(3).trim().toLowerCase().equals("true")) {
					isOffence = true;
				}
				MagicCard m = new MagicCard(
						Integer.parseInt(list.get(1).trim()), list.get(2), isOffence);
				deck.put(list.get(0).trim() + m.getCardNum(), m);
				list.clear();
			}

		}
	}

	public Map<String, Card> getDeck(){
		return deck;
	}
	/**
	 * Adds a card to the Map. 
	 * @param type - "M" for MagicCard "C" for CreatureCard
	 * @param c - a Card object
	 * @return
	 */
	private boolean addCard(String type, Card c) {
		if (type.trim().equals("C") || type.trim().equals("C")) {
			deck.put(type + c.getCardNum(), c);
			return true;
		}
		else if (type.trim().equals("M") || type.trim().equals("m")) {
			deck.put(type + c.getCardNum(), c);
			return true;
		}
		else {
			return false;
		}

	}

	/**
	 * Picks a random card and removes it from the Deck.
	 * PreCondition: Deck must have at least one card
	 * 
	 * @return Card - the card removed
	 */
	public Card pickCard() {
		Random random = new Random();
		List<String> keys = new ArrayList<String>(deck.keySet());
		String randomKey = keys.get(random.nextInt(keys.size()));
		Card value = deck.get(randomKey);
		removeCard(randomKey);
		return value;
	}

	/**
	 * Removes the card from this Map using a key.
	 * 
	 * @param key - removes the Card with this key
	 * @return Card - the card removed
	 */
	private Card removeCard(String key) {
		return deck.remove(key);
	}

	/**
	 * Deck's toString
	 */
	public String toString() {
		if (deck.isEmpty()) {
			return "Deck is empty";
		}
		return deck.toString();
	}
	
	/**
	 * Tests Deck class
	 */
	public static void main(String[] args) {
		Deck deck = new Deck(true);						//puts cards in map
		System.out.println(deck.pickCard().toString()); //gets a random card
		//System.out.println(deck.toString());				//random card should not display
	}
}//class Deck
