import java.util.*;
/**
 * [Description]
 * 
 * @author (Michael Arteaga, [add names]) 
 * @version (Oct 1, 2014)
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
        //reads file input
    }
    
    public void addMonsterDeck() {
        //reads input from file
    }
    
    public void addMagicDeck() {
        //reads input from file
    }
    
    public List<Card> getHand() {
        return currentHand; //comment change//Joe's change
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
