/**
 * Class CreatureCard is an object that holds attributes for a Creature including
 * methods to attack another creature. The CreatureCard has a specific element
 * type that is strong against one another and can use MagicCard to enhance their
 * attack power or help defend themselves against an attack on them.
 *
 * @author (Michael Arteaga, Joseph Carbone, Peter Cipolone, Eric Oliver)
 * @version (Nov 19, 2014)
 */
public class CreatureCard extends Card
{
	private boolean isRare;
    private int attack;
    private int health;
    private String element;
    
    public static void main(String[] args) {
        CreatureCard monster1 = new CreatureCard(1,"Monster1",30,100,"FIRE",true);
        CreatureCard monster2 = new CreatureCard(2,"Monster1",30,100,"GRASS", false);
        MagicCard special = new MagicCard();
        special.setName("Magie");
        monster1.setName("Monster 1");
        monster2.setName("Monster 2");
        monster1.setNumber(20);
        monster2.setNumber(30);
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        monster1.attacks(monster2);
        monster1.useMagic(special, monster2);
        monster1.useMagic(special, monster2);
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        System.out.println(special.toString());
    }
    

    /**
     * Default constructor for objects of class Creature Card
     */
    public CreatureCard() {
        cardName = "[default]"; //will change when can read from file
        attack = 10;
        health = 100;
        isRare = false;
        element = "FIRE";
    }
    /**
     * CreatureCard constructor with specific detail
     * @param attack @param health @param isRare
     */
    public CreatureCard(int num, String name, int attack, int health, String element, boolean isRare) {
        super(num,name);
        this.attack = attack;
        this.health = health;
        this.isRare = isRare;
        this.element = element;
    }

    public int getAttackDamage() {
        return attack;
    }

    public double getHealth() {
        return health;
    }
    
    public String getElement() {
    	return element;
    }
    
    public void setElement(String t) { //Mutator Methods
    	element = t;
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
    	if (element.equals("FIRE") && monster2.getElement().equals("GRASS") ||
    		element.equals("WATER") && monster2.getElement().equals("FIRE") ||
    		element.equals("GRASS") && monster2.getElement().equals("WATER")) {
    		
    		monster2.takesHit(getAttackDamage()*3);
    		return;
    	}
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
        "\n  Element: " + element +
        "\n  Rare: " + isRare;
    
    }
}//class CreatureCard()

