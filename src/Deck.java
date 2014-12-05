import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Joe Carbone
 *
 */
public class Deck {
	//private Map<String, Card> hand = new TreeMap<String, Card>();
	private Map<String, Card> deck = new TreeMap<String, Card>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.createDeck();
		deck.getDeck();
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
	
	public void createDeck() {
		ArrayList<String> list = new ArrayList<String>();
		Scanner scan = openFile();
		scan.useDelimiter(",");
		while (scan.hasNext()) {
			list.add(scan.next());
			if (list.size() == 7) {
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
		}
		//System.out.println(list); Sanity check
		//System.out.println(deck);

	}
	
	public Map<String, Card> getDeck(){
		System.out.println(deck);
		return deck;
	}
	
	public boolean addCard(String type, Card c) {
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

	public Card pickCard() {
		Random random = new Random();
		List<String> keys = new ArrayList<String>(deck.keySet());
		String randomKey = keys.get(random.nextInt(keys.size()));
		Card value = deck.get(randomKey);
		removeCard(randomKey);
		return value;
	}
	
	public Card removeCard(String key) {
		return deck.remove(key);
	}
	
	public String toString() {
		return null;
	}

}
