
public class Dino {

	private int level;
	private String name;
	private int health=700;
	private int stam=175;
	private int torpor=420;
	
	private int healthIncrease=140;
	private int stamIncrease=17;
	private int torporIncrease=25;
	
	public Dino(int level, String name, int health, int stam, int torpor) {
		
		this.setLevel(level);
		this.setName(name);
		this.setHealth(health);
		this.setStam(stam);
		this.setTorpor(torpor);
	}
	
	public Dino(int level) {
		
		this.setLevel(level);
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}


	public int getStam() {
		return stam;
	}


	public void setStam(int stam) {
		this.stam = stam;
	}


	public int getTorpor() {
		return torpor;
	}


	public void setTorpor(int torpor) {
		this.torpor = torpor;
	}
	
	public void calculateStats(int level) {
		
		this.health=(healthIncrease*(level-1)) + health;
		this.stam=(stamIncrease*(level-1)) + stam;
		this.torpor=(torporIncrease*(level-1)) + torpor;
		
	}
	
	
}
