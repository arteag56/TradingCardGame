package src;

import java.util.*;
//1,1,Monster,10,100,true

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
    private int currentPlayer = 0;
    private boolean gameResult;
    private int turn;
    private Random random;
    

    //needs field
    
    public static void main(String args[]) {
    	GameBoard game = new GameBoard();
    	System.out.println(game.whoStartsGame());
    }

    /**
     * Constructor for objects of class Board
     */
    public GameBoard() {
        player1 = new Player("Peter");
        player2 = new Player("Joe");
        turn = 0;
        
    }
    
    public GameBoard(String name1, String name2) {
    	player1 = new Player(name1);
        player2 = new Player(name2);
        turn = 0;
    }

    /**
     * This method keeps track of who wins the game 
     * and the record of the players
     * @return result - the winner 
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
    public String whoStartsGame()
    {
    	random = new Random();
    	currentPlayer = random.nextInt(2);
    	if (currentPlayer == 0) {
    		return player1.getName();
    	}
    	return player2.getName();
    }
    
    public String getPlayer1Name() {
    	return player1.getName();
    }
    
    public String getPlayer2Name()
    {
        return player2.getName();
    }
    
    public Map getPlayer1Deck()
    {
        return player1.getDeck();
    }
    
     public Map getPlayer2Deck()
    {
        return player2.getDeck();
    }
    
    public List<Card> getPlayer1Hand()
    {
        return player1.getHand();
    }
    
    public List<Card> getPlayer2Hand()
    {
        return player2.getHand();
    }
    
    public void player1NewTurn()
    {
        player1.newTurn();
    }
    
     public void player2NewTurn()
    {
        player2.newTurn();
    }
    
    /**
     * 
     */
    public Card displayCardsPlayed()
    {
        return null;
    }
    
    public boolean completedMove() {
		return(player1.playedMonster()&&player1.playedMagic()||player2.playedMonster()&&player2.playedMagic());
	}
    
    /**
     * 
     */
    public int displayPlayerHealth(int n)
    {
        if (n == 1) {
        	return player1.getHealth();
        }
        return player2.getHealth();
        
    }
    
    public String nextTurn() {
    	currentPlayer++; 
    	if (currentPlayer % 2 == 0) {
    		return player1.getName();
    	}
    	else {
    		return player2.getName();
    	}
    	
    }
    
    
    
    /**
     * 
     */
    public String displayPlayerNamesAndRecords()
    {
        return null; //this is a github test
    }

    
}
