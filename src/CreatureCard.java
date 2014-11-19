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
    private Type type;
    
    public static void main(String[] args) {
        CreatureCard monster1 = new CreatureCard();
        CreatureCard monster2 = new CreatureCard();
        MagicCard special = new MagicCard();
        special.setName("Magie");
        monster1.setName("Monster 1");
        monster2.setName("Monster 2");
        monster1.setNumber(20);
        monster2.setNumber(30);
        //monster2.Type.FIRE;
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        monster1.attacks(monster2);
        monster1.useMagic(special, monster2);
        monster1.useMagic(special, monster2);
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        System.out.println(special.toString());
    }
    
    public enum Type {
    	FIRE, GRASS, WATER
    }

    /**
     * Default constructor for objects of class Creature Card
     */
    public CreatureCard() {
        cardName = ""; //will change when can read from file
        attack = 10;
        health = 100;
        isRare = false;
        type = null;
    }
    /**
     * CreatureCard constructor with specific detail
     * @param attack @param health @param isRare
     */
    public CreatureCard(int attack, int health, boolean isRare, Type t) {
        cardName = super.getName();
        this.cardNum = super.getCardNum();
        this.attack = attack;
        this.health = health;
        this.isRare = isRare;
        type = t;
    }
    
    public String getName() { //Accessor Methods
        return super.cardName;
    }

    public int getAttackDamage() {
        return attack;
    }

    public double getHealth() {
        return health;
    }
    
    public Type getType() {
    	return type;
    }
    
    public void setType(Type t) { //Mutator Methods
    	type = t;
    }

    public void setName(String newName) {
        super.setName(newName);
    }

    private void setNumber(int i) {
        super.setCardNumber(i);
    }

    public void setAttackDamage(int newAttack){
        attack = newAttack;
    }

    public void setHealth(int newHealth){
        health = newHealth;
    }

    /**
     * This CreatureCard takes a hit against it's health.
     * @param hitTaken
     * @
     */
    public boolean takesHit(int hitTaken){
        health = health - hitTaken;
        if (health <= 0){
            health = 0;
            System.out.println("Die Mothafucker");
            return true;
        }
        else{
            System.out.println("Health Remaining: " + health);
            return false;
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
    public void useMagic(Card c, CreatureCard monster){
        if (isRare && c instanceof MagicCard){
        	MagicCard card = (MagicCard) c;
        	if (card.isOffense()) {
        		monster.takesHit(attack + 20);
        	}
        	else {
        		takesHit((monster.getAttackDamage())/2);
        	}
            
        }
    
    }

    public String toString() {
        return super.toString() +
        "\n  Type: Monster" +
        "\n  Attack: " + attack +
        "\n  Health: " + health +
        "\n  Rare: " + isRare;
    
    }
}//class CreatureCard()

