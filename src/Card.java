import java.util.Scanner;
import java.io.*;
/**
 * The card class will have attributes that each type of card should have
 * 
 * @author (Michael Arteaga, [add your names]) 
 * @version (Oct 1, 2014)
 */
public class Card
{
    private String cardName;
    private int cardNum;

    /**
     * Default constructor
     */
    public Card () {
        cardName = "[no name]";
        cardNum = 0;
    }

    /**
     * Contructor with card input
     */
    public Card (String name, int number) {
        cardName = name;
        cardNum = number;
    }

    public String getName() {
        return cardName;
    }
    
    public int getCardNum() {
        return cardNum;
    }

    /**
     * Obtain the name of the file and open the file for reading. Attempt to 
     * recover from the typical I/O exceptions with a limited number of retries (3).
     */
    public Scanner openFile() {
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

        }
        return scan;
    }

    public String toString () {
        return "Card name: " + cardName +
        "Card number: " + cardNum;
    }
}
