/**
 * [Description]
 *
 * @author (Michael Arteaga, Eric Oliver[add names])
 * @version (Oct 1, 2014)
 */
public class CreatureCard extends Card
{
    private int value; //not needed?
    private boolean isRare;
    private int attack;
    private int health;
    private String cardName;
    private int cardNum;
    public static void main(String[] args) {
        CreatureCard monster1 = new CreatureCard();
        CreatureCard monster2 = new CreatureCard();
        MagicCard special = new MagicCard();
        special.setName("Enhancement");
        monster1.setName("Monster 1");
        monster2.setName("Monster 2");
        monster1.setNumber(20);
        monster2.setNumber(30);
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        //monster1.attacks(monster2);
        //monster1.changeRare();
        monster1.useMagic(special, monster2);
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
    }

    /**
     * Default constructor for objects of class Creature Card
     */
    public CreatureCard() {
        cardName = ""; //will change when can read from file
        attack = 10;
        health = 100;
        isRare = false;
    }

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

    /**
     * Gets the power of the card
     */
    public int getCardValue() {
        return value;
    }

    public int getAttackDamage() {
        return attack;
    }

    public double getHealth() {
        return health;
    }

    public void setName(String newName) {
        //cardName = newName;
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
            System.out.println("Health Remaining:" + health);
        }
    }

    /**
     * @param monster2
     */
    private void attacks(CreatureCard monster2) {
        //Write code here
        //using takesHit() method changes the health of creature
        monster2.takesHit(getAttackDamage());
    }

    public boolean changeRare() {
        //needs to change rarity so if true change to false and if its false change to true
        //return false IF rarity did not change, this is a sanity check. for Debugging
        if (isRare == false){
            isRare = true;
        }
        else{
            isRare = false;

        }
        return true;
    }
    
    public void useMagic( Card c, CreatureCard alien ){
        int killer = attack;
        
        if (isRare == true && c instanceof MagicCard){
            killer = killer + 20;
            alien.takesHit(killer);
        }
    
    }

    public String toString() {
        return super.toString() +
        " Type: Monster" +
        " Attack: " + attack +
        " Health: " + health +
        " Rare: " + isRare;
    }
}//class CreatureCard()

