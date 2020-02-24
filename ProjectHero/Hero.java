package heroes;

import java.util.Arrays;

public class Hero extends Abstract implements Talent{
	private int hp;
	private int baseDamage;
	private String name;
	private int healconstant;
	public int heal;
	public int hpMin;
	
	public Hero(String name, int hp, int baseDamage) {
		this.hp = hp;
		this.baseDamage = baseDamage;
		this.name = name;
		this.healconstant = hp;
		this.heal = heal;
		this.hpMin = hpMin;
	}
	
	/* ubah method attack agar bisa menyerang lebih dari satu 1 target hero
	 * dalam 1 kali serangan*/
	
	public void attack(Talent... target) {
		int i = 0;
		while (i<target.length) {
			target[i].getHit(baseDamage);
		System.out.println("Hero " + this.name + " attacking "+ target[i]);
		System.out.println();
		i++;
		
		}	
	}
	

	public void getHit (int damage) {
		hp = hp - damage;
		
		if(hp>damage && hp>100)
		  {
			System.out.println("Hero " + this.name + " is life, taken " + damage + "hp ");
		  }else if 
		  (hp < 100 && hp >0)
		   {hp= hp + 10;
		   System.out.println();
			  System.out.println(this.name + " is life");
		System.out.println("shield activated for protect hp (+10 shield) : " + hp); 
			}
		  else if( hp <= 0) {
			  hp = 0;
			  System.out.println(this.name + " has been slined " );
			  
		  System.out.println("is cannot attack this hero");
		  }

		
		/* kondisi :
		* jika Hp hero target lebih kecil atau sama dengan 0, maka tidak dapat di heal.
		* jika hp hero target lebih dari 0, maka akan di heal sejumlah 25% HP hero tsb.
		* HP yang di heal tidak bisa melebihi HP yang di set di cunstuctor.
		* 
		*/
		
		/*
		 *Ubah method, dengan kodisi :
		 *- Jika HP hero  <= 0, hero dianggap tewas ditempat.
		 *- Hero yang tewas di tempat tidak dapat diheal  
		 */
		
		
	}
	public void heal (Hero target) {
		if(this.getHp()>0) {
			
			if(target.hp <= 0) {
				System.out.println(this.name + " is cannot be heal");
				System.out.println(this.name + " is dead");
				System.out.println("heal to "+this.name + " is not activated");
				System.out.println();
			} else if(target.hp > 0) {
				target.hp = target.hp +((healconstant * 25)/100);
				heal = (healconstant * 25)/100;		
				System.out.println("heal to "+ this.name + " is activated : "+ "+ " + heal + " heal");
				System.out.println();
			} if(target.hp >= healconstant) { 
				target.hp = healconstant; 
				System.out.println("heal max " + healconstant +" to " +this.name);
			}else {
				System.out.println(this.getName() + " Is Dead");
			}
		}
			

		}
		
		
	
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return "Hero " + this.name + ", "+this.name+ " update : " + "[ "+ "hp=" + hp + ", baseDamage=" + baseDamage + " ]";
	}

	@Override
	void heal() {
		// TODO Auto-generated method stub
		
	}
	
	

}
