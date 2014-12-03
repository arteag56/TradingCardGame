import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * @author Joe Carbone
 *
 */
public class Deck {
	public CreatureCard tempCreature;
	public MagicCard tempMagic;
	public HashMap <String, Card> allCards;
	public Stack<Card> deck;
	public ArrayList<Card> hand;
	public String playerName = "";

	public static void main(String[] args) 
	{
		//create main
	}
	public ArrayList<Card> getHand() 
	{
		while(hand.size()<5)
		{drawCard();}
		return hand;
	}
	public Card drawCard()
	{
		hand.add(deck.peek());
		return deck.pop();
	}
	public void shufflesDeck() 
	{
		Collections.shuffle(deck);
	}
	public void allCards()
	{
		try
		{
			String line;

			Scanner scan = new Scanner (new File ("MonsterDeckTest.txt"));
			playerName=scan.nextLine();
			while(scan.hasNextLine())
			{
				for(int i=0;i<4;i++)
				{ line = scan.nextLine();
				temp.add(line);
				}
				deck.push(temp);
				temp.clear();
			}
			scan.close();
		}
		catch (FileNotFoundException fnfe)
		{ System.err.println (fnfe); }
	}
	private Card addDeck (Card newCard)
	{
		return deck.push(newCard);
	}

	public Card next()
	{
		return deck.pop();
	}
	public Card remove(String cardNumber)
	{
		Card temp=null;//=allcards.value(cardNumber);
		hand.remove(temp);
		return temp;
	}
	public Set<String> attributes(int key)
	{
		return allCards.get(key);
	}
	public void main()
	{
		allCards();
		addDeck(1);
		int key=next();
		System.out.println(attributes(key));
	}
}
