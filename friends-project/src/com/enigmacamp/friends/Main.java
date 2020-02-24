package com.enigmacamp.friends;

import java.util.List;

import com.enigmacamp.friends.db.models.PersonModel;
import com.enigmacamp.friends.person.Person;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("PROJECT: test-java");
			// TODO Auto-generated method stub
			PersonModel model = new PersonModel();
			List<Person> persons = model.findAll();
			
			System.out.println("LIST");
			for(Person person: persons) {
				System.out.println(person);
			}
			System.out.println("\n\n");
			
			Person adis = model.find(1);
			Person edi = model.find(2);
			Person joe = model.find(5);
			Person roy = model.find(6);
			
			System.out.println(adis.getName() + ":");
			System.out.println(adis.getFriends());
			System.out.println("\n");
			System.out.println(edi.getName() + ":");
			System.out.println(edi.getFriends());
			System.out.println("\n");
			
			List<Person> mutualFriends = model.getMutualFriends(adis, edi);
			System.out.println("mutual of " + adis.getName() + " and " + edi.getName() + ":");
			System.out.println(mutualFriends);
			
			
			model.addFriends(adis, joe);
			model.addFriends(adis, roy);
			model.addFriends(edi, roy);
			
			System.out.println("\n");
			System.out.println(adis.getName() + "after add friend:");
			System.out.println(adis.getFriends());
			
			model.unfriend(adis, joe);
			System.out.println("\n");
			System.out.println(adis.getName() + " after unfriend:");
			System.out.println(adis.getFriends());
			
//			Person edi = model.find(2);
//
//			System.out.println("EDI: ");
//			System.out.println(edi);
//			System.out.println("\n\n");
//			
//			Person nobody = model.find(5);
//
//			System.out.println("NOBODY:");
//			System.out.println(nobody);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
