package heroes;

public abstract class Abstract {
	
	private int hp;
	private int baseDamage;
	private String name;
	private int healconstant;
	
	abstract void attack(Talent... target);
	abstract void getHit(int damage);
	abstract void heal();
	
	
	public int getBaseDamage() {
		return baseDamage;
	}
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void heal(Hero target) {
		// TODO Auto-generated method stub
		
	}
	
	
//	public void attack(Talent[] target) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
//	public void attack(Talent... target) {
//		int i = 0;
//		while (i<target.length) {
//			target[i].getHit(baseDamage);
//		System.out.println("Hero " + this.name + " attacking "+ target[i]);
//		System.out.println();
//		i++;
//		
//		}
//		
//	}
//		
//	
//	public void getHit(int damage) {
//		hp = damage - damage;
//		
//	}
 
}
