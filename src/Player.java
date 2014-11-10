import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * [Description]
 * 
 * @author (Michael Arteaga, Joseph Carbone) 
 * @version (Oct 24, 2014)
 */
public class Player
{
    List<MagicCard> magicDeck = new ArrayList<MagicCard>();
    List<CreatureCard> monsterDeck = new ArrayList<CreatureCard>();
    List<Card> currentHand = new ArrayList<Card>();

    /**
     * Constructor for objects of class Player
     */
    public Player() {
     
        try
        {
        String line;
        Scanner scan = new Scanner (new File ("monsterdeck.txt"));
        while (scan.hasNextLine())
            {   line = scan.nextLine();
                ///monsterDeck.add (line);
            }
        scan.close();
        }
        catch (FileNotFoundException fnfe)
        {   System.err.println (fnfe);  }
    }
    
    public static void main(String args[]) {
    	
    }

        /** @return The list of words generated
         *  by the constructor.
         */
    //public List <String> getMonsterDeck() { return monsterDeck; }
     
    public void addMonsterDeck() {
        //reads input from file
    }
    
    public void addMagicDeck() {
        //reads input from file
    }
    
    public List<Card> getHand() {
        return currentHand; 
    }
    
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

}
