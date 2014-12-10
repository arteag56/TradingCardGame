
/**
 * Card class is a superclass for all cards used in the GameBoard
 * 
 * @author (Michael Arteaga, Joseph Carbone, Peter Cipolone, Eric Oliver) 
 * @version (Nov 19, 2014)
 */
public class Card
{
	protected String cardName;
	protected int cardNum;

	/**
	 * Default constructor
	 */
	public Card () {
		cardName = null;
		cardNum = 0;

	}

	/**
	 * Constructor with card input
	 */
	public Card (int number, String name) {
		cardName = name;
		cardNum = number;

	}

	/**
	 * Gets the name of the card
	 * @return cardName
	 */
	public String getName() {
		return cardName;
	}

	/**
	 * Gets the card number
	 * @return cardNum
	 */
	public int getCardNum() {
		return cardNum;
	}

	/**
	 * Changes the name of the card
	 * @param newName
	 */
	public void setName(String newName) {
		cardName = newName;
	}

	/**
	 * Changes the card number
	 * @param i
	 */
	public void setCardNumber(int i){
		cardNum = i;
	}

	/**
	 * Prints out card information
	 */
	public String toString () {
		return "Card name: " + cardName +
				"\nCard number: " + cardNum;
	}
}//class Card
