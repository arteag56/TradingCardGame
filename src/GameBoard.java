import java.util.Random;
/**
 * [Description]
 * 
 * @author (Michael Arteaga, Joseph Carbone, Peter Cipolone, Eric Oliver) 
 * @version (Oct 1, 2014)
 */
public class GameBoard
{
     // instance variables - replace the example below with your own
    private Player player1;
    private Player player2;
    private String currentPlayer;
    private boolean gameResult;
    

    /**
     * Constructor for objects of class Board
     */
    public GameBoard(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public static void main(String args[]) 
    {
    	//GameBoardGUI gui = new GameBoardGUI();
    	Player p1 = new Player();
    	Player p2 = new Player();
    	GameBoard game = new GameBoard(p1,p2);
    	System.out.println(game.pickRandomTurn());
    }

    /**
     *This method returns a boolean                         
     *keeps track of who wins the game and 
     *the record of the players 
     */
    public String gameResult()
    {       
    	String result = null;
        //player has a health of 5, once a creature of his is killed
    	//it loses a heart. it reaches 0 game over other player wins.
    	//if (player1.getHealth() == 0)
    	//{
    	//	result = player1.getName();
    	//}
    	//	else {
    	//		result = player2.getName();
    	//	}
    	return result + " wins!";
    }
    
    /**
     * 
     */
    public static String pickRandomTurn()
    {
    	Random playerTurn = null;
    	if (playerTurn.nextInt(2) == 0) {
    		return "Player 1's turn";
    	}
    	return "Player 2's turn";
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
        return null; //this is a github test
    }

    
}
