import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



/**
 * @author Joe Carbone
 *
 */
public class Deck {

	private Set<String> temp;
	private HashMap <Integer, Set <String>>  allCards;
	private Stack<Integer> deck;
	private ArrayList<Integer> hand;

	public static void main(String[] args) {
		//create main
	}
	
	public ArrayList<Integer> getHand() {
		return hand;
	}
	public Card drawCard(){
		//draws and returns a Card
		return null;
	}
	public void shufflesDeck() {
		
	}
	public void allCards(){
		try
		{
			String line;
			int key=0;
			Scanner scan = new Scanner (new File ("MonsterDeckTest.txt"));
			while(scan.hasNextLine())
			{key++;       	
			for(int i=0;i<4;i++)
			{   line = scan.nextLine();
			temp.add(line);
			}
			allCards.put(key, temp);
			temp.clear();
			}
			scan.close();
		}
		catch (FileNotFoundException fnfe)
		{   System.err.println (fnfe);  }
	} 




	private int addDeck (int cardNumber)
	{return deck.push(cardNumber); 

	}

	public int addHand(int cardNumber)
	{hand.add(cardNumber);
	return cardNumber;	  
	}

	public int next()
	{return deck.pop();
	}

	public int remove(int cardNumber)
	{return hand.remove(cardNumber);
	}

	public Set<String> attributes(int key)
	{return allCards.get(key);
	}

	public void main()
	{allCards();
	addDeck(1);
	int key=next();
	System.out.println(attributes(key));


	}

}
