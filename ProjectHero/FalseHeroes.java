package heroes;

public class FalseHeroes extends Abstract implements Talent{


	public FalseHeroes(String name, int hp, int damage) {
	this.setName(name);
		
	}
	@Override
	public void attack(Talent... target) {
		int i = 0;
		while (i<target.length) {
			target[i].getHit(getBaseDamage());
		System.out.println("Hero " + this.getName() + " attacking "+ target[i]);
		System.out.println();
		i++;
		
		}
		
	}
	
	@Override
	public void getHit(int damage) {
		damage = getHp() + damage;
	}
	
	@Override
	public void heal (Hero target) {
		
	}
	@Override
	void heal() {
		// TODO Auto-generated method stub
		
	}

	

}
