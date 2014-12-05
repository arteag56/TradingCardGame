/**
 * Class CreatureCard is an object that holds attributes for a Creature including
 * methods to attack another creature. The CreatureCard has a specific element
 * type that is strong against one another and can use MagicCard to enhance their
 * attack power or help defend themselves against an attack on them.
 *
 * @author (Michael Arteaga, Joseph Carbone, Peter Cipolone, Eric Oliver)
 * @version (Dec 5, 2014)
 */
public class CreatureCard extends Card
{
	private boolean isRare;
    private int attack;
    private int health;
    private String element;
    
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

    public int getAttackDamage() {			//Accessor Methods
        return attack;
    }

    public double getHealth() {
        return health;
    }
    
    public String getElement() {
    	return element;
    }
    
    public void setElement(String t) { 		//Mutator Methods
    	element = t;
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
     * @return true if creature dies
     */
    public boolean takesHit(int hitTaken){
        if (hitTaken > 0) {
        	health = health - hitTaken;
        	if (health <= 0){
                health = 0;
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    /**
     * This CreatureCard attacks another CreatureCard
     * @param monster2
     */
    public void attacks(CreatureCard monster2) {
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
    public void useMagicOffense(Card c, CreatureCard monster){ //implement in Player class?
        if (isRare && c instanceof MagicCard){
        	MagicCard card = (MagicCard) c;
        	if (card.isOffense()) {
        		monster.takesHit(attack + 20);
        	}
        	
        }
    }

    public void useMagicDefense(Card d, CreatureCard monster){ 
        if(isRare && d instanceof MagicCard){
            MagicCard card = (MagicCard) d;
            if(!card.isOffense()){
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
    
    public static void main(String[] args) {
        CreatureCard monster1 = new CreatureCard(1,"Monster1",10,100,"WATER",true);
        CreatureCard monster2 = new CreatureCard(2,"Monster2",30,100,"GRASS", false);
        MagicCard special = new MagicCard(1,"Defense",false);
        //monster1.setCardNumber(20);
        //monster2.setCardNumber(30);
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        monster1.attacks(monster2);
        //monster1.useMagicDefense(special, monster2);
        //monster1.useMagicOffense(special, monster2);
        System.out.println(monster1.toString());
        System.out.println(monster2.toString());
        //System.out.println(special.toString());
    }
}//class CreatureCard()

