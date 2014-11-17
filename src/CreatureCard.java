/**
 * Class CreatureCard is an object that holds attributes for a Creature including
 * methods to attack another creature. The CreatureCard has a specific element
 * type that is strong against one another and can use MagicCard to enhance their
 * attack power or help defend themselves against an attack on them.
 *
 * @author (Michael Arteaga, Eric Oliver[add names])
 * @version (Oct 1, 2014)
 */
public class CreatureCard extends Card
{
    private boolean isRare;
    private int attack;
    private int health;
    private String cardName;
    private int cardNum; //change to key?
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
        monster1.attacks(monster2);
        monster1.useMagicOffense(special, monster2);
        monster1.useMagicDefense(special, monster2);
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
    /**
     * CreatureCard constructor with specific detail
     * @param attack @param health @param isRare
     */
    public CreatureCard(int attack, int health, boolean isRare) {
        cardName = super.getName();
        this.cardNum = super.getCardNum();
        this.attack = attack;
        this.health = health;
        this.isRare = isRare;
    }
    
    public String getName() { //Accessor Method
        return super.cardName;
    }

    public int getAttackDamage() { //Accessor Method
        return attack;
    }

    public double getHealth() { //Accessor Method
        return health;
    }

    public void setName(String newName) { //Mutator Method
        super.setName(newName);
    }

    private void setNumber(int i) { //Mutator Method
        super.setCardNumber(i);
    }

    public void setAttackDamage(int newAttack){ //Mutator Method
        attack = newAttack;
    }

    public void setHealth(int newHealth){ //Mutator Method
        health = newHealth;
    }

    /**
     * This CreatureCard takes a hit against it's health.
     * @param hitTaken
     */
    public void takesHit(int hitTaken){
        health = health - hitTaken;
        if (health <= 0){
            health = 0;
            System.out.println("Die Mothafucker");
        }
        else{
            System.out.println("Health Remaining: " + health);
        }
    }

    /**
     * This CreatureCard attacks another CreatureCard
     * @param monster2
     */
    private void attacks(CreatureCard monster2) {
        monster2.takesHit(getAttackDamage());
    }
    
    /**
     * CreatureCard uses a MagicCard to enhances it's attack power against 
     * another monster.
     * @param c @param monster
     */
    public void useMagicOffense(Card c, CreatureCard monster){
        if (isRare && c instanceof MagicCard){
            monster.takesHit(attack + 20);
        }
    
    }
    
   /**
     * Decreases the damage to current defending creature.
     * @param c @param monster
     */ 
    public void useMagicDefense(Card c, CreatureCard monster){
        if(isRare && c instanceof MagicCard){
           takesHit((monster.getAttackDamage())/2);
        }
    }

    public String toString() {
        return super.toString() +
        " Type: Monster" + "\n" +
        " Attack: " + attack + "\n" +
        " Health: " + health + "\n" +
        " Rare: " + isRare;
    
    }
}//class CreatureCard()

