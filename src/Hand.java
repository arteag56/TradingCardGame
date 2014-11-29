import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author Michael Arteaga
 *
 */
public class Hand {
	private Scanner scan;
	//private Map<Hashtable<Integer, Integer>, Card> hand = new TreeMap <Hashtable<Integer, Integer>, Card> ();
	private Map<String, Card> hand = new TreeMap <String, Card> ();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hand hand = new Hand();
		//hand.openFile();
		hand.addAllCards();

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
	
    public void addAll() {
    	Scanner scan = openFile();
    	ArrayList<String> list = new ArrayList<String>();
    	while (scan.hasNextLine()) {
    		list.add(scan.nextLine());
    		
    		list.remove(0);
    	}
    	System.out.println(list);
    	
    }
    
	public Map<Hashtable<Integer, Integer>, Card> viewHand() {
		return null;
	}
	
	public void addCard(Card c) {
		
	}
	public void addAllCards(){
        ArrayList<String> list = new ArrayList<String>();
        Scanner scan = openFile();
        //scan.useDelimiter(",");
        
        while (scan.hasNextLine()) {
            Scanner scanny = scan;
            //System.out.println(scan.nextLine());
            scanny.useDelimiter(",");
            while(scanny.hasNext()) {
                list.add(scanny.next());
                //System.out.println(list);
                if (list.size() == 7) {
                	boolean rare = false;
                    if (list.get(6).equals("true")) {
                        rare = true;
                    }
                    CreatureCard c = new CreatureCard(Integer.parseInt(list.get(1)), list.get(2), Integer.parseInt(list.get(3)),Integer.parseInt(list.get(4)), list.get(5), rare);
                    hand.put(list.get(0) + c.getCardNum(), c);
                    //list.clear();
                }
                //System.out.println(list);
            }
            System.out.println(list);
            System.out.println(hand);
        }
        
    }
	public Card removeCard() {
		return null;
	}
	
	

}
