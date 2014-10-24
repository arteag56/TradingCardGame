
/**
 * [Description]
 * 
 * @author (Michael Arteaga, [add names]) 
 * @version (Oct 1, 2014)
 */
public class CreatureCard extends Card
{
    private int value; //not needed?
    private boolean isRare;
    private double attackHit;
    private double health;
    private String cardName;
    private int cardNum;

    /**
     * Default constructor for objects of class Creature Card
     */
    public CreatureCard() {
        cardName = ""; //will change when can read from file
        attackHit = 0;
        health = 0;
        isRare = false;
    }
    
    public CreatureCard(double attackHit, double health, boolean isRare) {
        cardName = super.getName();
        this.cardNum = super.getCardNum();
        this.attackHit = attackHit;
        this.health = health;
        this.isRare = isRare;
    }

    /**
     * Gets the power of the card
     */
    public int getCardValue() {
        return value;
    }
    
    public double getAttackHit() {
        return attackHit;
    }
    
    public double healthLeft() {
        return health;
    }
    
    public boolean isRare() {
        return false;
    }
    
    public String toString() {
        return super.toString() + 
               "Type: Monster";
    }
}
