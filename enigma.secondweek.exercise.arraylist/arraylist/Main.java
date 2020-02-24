package enigma.secondweek.exercise.arraylist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {


	public static void main(String[] args) {
		List<Person> friend = new ArrayList<Person>();
		
		Person Chou = new Person("Chou", 20, friend);
		Person Grey = new Person("Grey", 22, friend);
		Person Leti = new Person("Leti", 23, friend);
		Person Burnley = new Person("Burnley", 24, friend);
		Person Backer = new Person("Backer", 23, friend);
		
		
		System.out.println("========================Friendster========================");
		Chou.addFriends(Grey, Leti, Backer);
		Burnley.addFriends(Grey, Leti);
		Chou.mutualFriend(Burnley);
		System.out.println();
		System.out.println("=======================Mutual Friend======================");
		System.out.println(Chou.mutualFriend(Burnley));
		System.out.println();
		System.out.println("======================Remove Friends======================");
		System.out.println();
		Chou.removeFriends(Leti);
		System.out.println();
		System.out.println("==========================ListFriend========================");
		System.out.println();
		friend.add(Burnley);
		friend.add(Backer);
		friend.add(Chou);
		friend.add(Grey);
		System.out.println(friend);
		
		System.out.println();
		for(Person ex: friend) {
			System.out.println(ex);
		}
		System.out.println("Arrays List : " + friend.size());

		
	}

}
