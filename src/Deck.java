import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



/**
 * @author Joe Carbone
 *
 */
public class Deck {

	public Set<String> temp;
	public HashMap <Integer, Set <String>>  allCards;
	public Stack<Integer> deck;
	public ArrayList<Integer> hand;

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
