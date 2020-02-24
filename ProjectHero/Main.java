package heroes;

//import java.beans.FeatureDescriptor;

public class Main {

	public static void main(String[] args) {
		
		Hero Harley = new Hero("Harley", 25, 50);
		Hero Florentino = new Hero("Florentino",900,25);
		Hero BlackPhanter = new Hero ("BlackPhanter",50, 50);
		Hero Lancelot = new Hero ("Lancelot",135,50);
		Hero Musuh [] = { Harley, BlackPhanter, Lancelot };
		Hero MusuhAll [] = { Harley, BlackPhanter, Lancelot, Florentino };

		FalseHeroes palsu = new FalseHeroes("Shadow", 200, 100);
		minion pion = new minion("Pion", 30, 20);
		Tower tiang = new Tower("Tower", 200, 200);
		
		System.out.println("===============================    List Name Hero    =========================================");
		System.out.println("=========================== with info HP and DAMAGE hero =====================================");
		System.out.println();
		System.out.println(Harley);
		System.out.println(Florentino);
		System.out.println(BlackPhanter);
		System.out.println(Lancelot);
		System.out.println();
		System.out.println("==============================================================================================");
		System.out.println("");
		
		Florentino.attack(Harley,BlackPhanter,Lancelot);
		palsu.attack(Musuh);
		Florentino.attack(pion, tiang);
		
		pion.attack(MusuhAll);
		Harley.attack(pion);
		 
			
	
	
		

	}
	
	

}
