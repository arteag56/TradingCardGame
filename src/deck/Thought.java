package deck;
import java.util.*;
import java.io.*;

/**
 * @author Joe Carbone
 *
 */
public class Thought {
	public Set <String> deck ();
	public void deckList()
    {   
    try
    {
    String line;
    Scanner scan = new Scanner (new File ("MonsterDeckTest.txt"));
    while (scan.hasNextLine())
        {   line = scan.nextLine();
            deck.add (line);
        }
    scan.close();
    }
    catch (FileNotFoundException fnfe)
    {   System.err.println (fnfe);  }
    }
	public List<String> getDeckList(){
		return deck;
	}
	public void main()
	{ 
	System.out.println(deck);}
}
