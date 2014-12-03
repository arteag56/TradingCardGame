import java.util.Scanner;
import java.io.*;
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
     * Obtain the name of the file and open the file for reading. Attempt to 
     * recover from the typical I/O exceptions with a limited number of retries (3).
     */
    public static Scanner openFile() {
        String nameOfFile; 
        Scanner scan = null;
        boolean success = false;
        int attempt = 3;

        while (attempt > 0 && !success) {

            System.out.println("Enter Name of File: ");
            Scanner inputRead = new Scanner(System.in);
            nameOfFile = inputRead.next();

            try{
                scan = new Scanner(new File(nameOfFile));
                success = true;
                System.out.println("\n" + nameOfFile + " was read successfully!");
            }
            catch(IOException e){
                System.out.println(e.getMessage() + "\n");
                attempt--;
                if (attempt > 0) {
                    System.out.println(attempt + " attempts left.");
                }
                else {
                    System.out.println("You failure.");
                }

            }

        }//while loop
        return scan;
    }
    
    /**
     * Prints out card information
     */
    public String toString () {
        return "Card name: " + cardName +
        		"\nCard number: " + cardNum;
    }
}//class Card
