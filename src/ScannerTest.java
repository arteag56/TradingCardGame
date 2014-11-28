

import java.util.*;
/**
 * @author Michael Arteaga
 *
 */
public class ScannerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Hashtable<Integer, Integer>, Card> hand = new TreeMap <Hashtable<Integer, Integer>, Card> ();
		Scanner fromStr = new Scanner("1,0,Mikeachu,30,100,false,FIRE");
		//ArrayList<String> holder = new ArrayList<String>();
		fromStr.useDelimiter(",");
		int counter = 0;
		int cardType = 0;
		int cardNum = 0;
		
		while(fromStr.hasNext()) {
			String temp = fromStr.next();
			if (counter == 0) {
				//store into first value of key
				
			}
			//store the second value value of key
			System.out.println(temp);
			counter++;
		}

	}

}
