/**
 * Driver class will test out all methods to make sure they are executed correctly
 * 
 * @author (Michael Arteaga, [put names]) 
 * @version (Oct 15, 2014)
 */
public class Driver
{
    /**
     * Constructor for objects of class Driver
     */
    public static void main(){
        Player p1 = new Player();
        Player p2 = new Player();
        GameBoard game = new GameBoard(p1,p2);
        Creature g = new Creature();
        g.setAttack(50);
        g.setHeath(100);
    }
    
}
