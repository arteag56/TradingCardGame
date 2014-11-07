/**
 * [Description]
 *
 * @author (Michael Arteaga, [add names])
 * @version (Oct 1, 2014)
 */
public class CreatureCard extends Card {
	
    private boolean isRare;
    private int attack;
    private int health;
    private String cardName;
    private int cardNum;
    public static void main(String[] args) {
        CreatureCard monster1 = new CreatureCard();
        CreatureCard monster2 = new CreatureCard();
        monster1.setName("Monster 1");
        monster2.setName("Monster 2");
        monster1.setNumber(20);
        monster2.setNumber(30);
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        monster1.attacks(monster2);
        monster1.changeRare();
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
    }

    /**
     * Default constructor for objects of class Creature Card
     */
    public CreatureCard() {
        cardName = null; //will change when can read from file
        attack = 10;
        health = 100;
        isRare = false;
    }
    /**
     * Creature card constructor with specific attributes.
     */
    public CreatureCard(int attack, int health, boolean isRare) {
        cardName = super.getName();
        this.cardNum = super.getCardNum();
        this.attack = attack;
        this.health = health;
        this.isRare = isRare;
    }

    public String getName() {
        return cardName;
    }

    public int getAttackDamage() {
        return attack;
    }

    public double getHealth() {
        return health;
    }

    public void setName(String newName) {
        super.setName(newName);
    }

    /**
     * @param i
     */
    private void setNumber(int i) {
        super.setCardNumber(i);
    }

    public void setAttackDamage(int newAttack){
        attack = newAttack;
    }

    public void setHealth(int newHealth){
        health = newHealth;
    }

    public void takesHit(int HitTaken){
        health = health - HitTaken;
        if (health <= 0){
            health = 0;
            System.out.println("Bitch you dead");
        }
        else{
            System.out.println(super.cardName + " health Remaining : " + health);
        }
    }

    /**
     * @param monster2
     */
    private void attacks(CreatureCard monster2) {
        monster2.takesHit(getAttackDamage());
    }

    public boolean changeRare() {
        if (isRare){
            isRare = false;
        }
        else{
            isRare = true;

        }
        return true;
    }

    public String toString() {
        return super.toString() +
        " Type: Monster" +
        " Attack: " + attack +
        " Health: " + health +
        " Rare: " + isRare;
    }
}//class CreatureCard()
