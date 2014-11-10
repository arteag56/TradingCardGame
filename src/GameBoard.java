
/**
 * [Description]
 * 
 * @author (Michael Arteaga, Peter Cipolone, 
 * @version (Oct 1, 2014)
 */
public class GameBoard
{
     // instance variables - replace the example below with your own
    private Player player1;
    private Player player2;
    private String currentPlayer;
    //private Card deck; //each player holds their own deck
    private Card inPlayField; //should be ArrayList? Maybe? idk 
    private boolean gameResult;

    /**
     * Constructor for objects of class Board
     */
    public GameBoard(Player player1Name, Player player2Name)//, Card deckName)
    {
        player1 = player1Name;
        player2 = player2Name;
        currentPlayer = ""; 
        //deck = deckName;
        inPlayField = null; //fill in later
        gameResult = true;// fill in later 
        
    }
    
    public static void main(String args[]) {
    	GameBoardGUI gui = new GameBoardGUI();
    	Player p1 = new Player();
    	Player p2 = new Player();
    }

    /**
     *This method returns a boolean                         
     *keeps track of who wins the game and 
     *the record of the players 
     */
    public boolean gameResultTracker()
    {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
        return false;
    }
    
    /**
     * 
     */
    public void playerturn()
    {
        
    }
    
    /**
     * 
     */
    public Card displayCardsPlayed()
    {
        return null;
    }
    
    /**
     * 
     */
    public int displayPlayerHealth()
    {
        return 0;
    }
    
    /**
     * 
     */
    public String displayPlayerNamesAndRecords()
    {
        return null;
    }

    
}
