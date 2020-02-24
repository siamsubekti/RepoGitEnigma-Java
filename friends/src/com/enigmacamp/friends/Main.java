package com.enigmacamp.friends;

import java.util.List;

import com.enigmacamp.friends.db.models.PersonModel;
import com.enigmacamp.friends.enums.Gender;
import com.enigmacamp.friends.person.Person;

public class Main {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			Person ininama = new Person(20, "BaruGanti", "1998-02-10", Gender.Male);
			Person inisetganti = new Person(20, "TestUpdate", "1998-02-10", Gender.Male);
			
			
			PersonModel model = new PersonModel();
			Person test = model.find(20);
			Person Florent = model.find(4);
			
			System.out.println("Insert Person : ");
//			model.create(ininama);
//			model.create(ininama);
			System.out.println("\n");
			
			System.out.println("Update : ");			
//			Florent.setGender(Gender.Male);
//			model.update(Florent);
			System.out.println("\n\n");
			
			System.out.println("Delete : ");
//			model.delete(inisetganti);
			System.out.println("\n\n");
			
			List<Person> persons = model.findAll();
					
			System.out.println("LIST");
			for(Person person: persons) {
				System.out.println(person);
			}
			System.out.println("\n\n");
			
			Person beby = model.find(3);
			System.out.println("\n\n");
			Person friends3 = model.find(3);
			Person friends4 = model.find(4);
			Person friends7 = model.find(7);
			Person friends8 = model.find(8);
			Person friends6 = model.find(6);
			Person friends10 = model.find(10);
			Person friends11 = model.find(11);
			
			System.out.println("\n\n");
			System.out.println("Beby: ");
			System.out.println(beby);
			System.out.println("\n\n");
			
			Person nobody = model.findByName("Florent;");

			System.out.println("FIND name :");
//			System.out.println(nobody);
			Person dewi = model.findByName("Dewi");		
			System.out.println(dewi);
			System.out.println("\n\n");
			
			
			
			System.out.println("List Friend : ");
			
			List<Person> persons2 = model.getFriends(beby);
			for (Person ps : persons2) {
				System.out.println(ps);
			}
			System.out.println("\n\n");
			
			System.out.println("Person & Friend list : ");
			model.PersonAndFriendList();
			System.out.println("\n\n");
			
			System.out.println("Mutual Friend : ");
			System.out.println(model.getMutualFriends(friends3,friends4));
			System.out.println("\n\n");
			
			
			//get addfriend :
			System.out.println("addFriend : ");
			model.addFriends(friends8, friends11, friends10, friends3);
//			model.addFriends(friends7, friends4);
			System.out.println("\n\n");
			
			//UnFriend :
			System.out.println("Unfriend : ");
//			model.unfriend(friends8, friends3);
//			model.unfriend(friends8, friends10);
			System.out.println("\n\n");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
