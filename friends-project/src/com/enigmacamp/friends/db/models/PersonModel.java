package com.enigmacamp.friends.db.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enigmacamp.friends.db.Database;
import com.enigmacamp.friends.enums.Gender;
import com.enigmacamp.friends.person.Person;

public class PersonModel {
	private Database db = new Database();
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		
		try {
			ResultSet result = this.db.executeQuery("SELECT p.id, p.name, p.birthdate, g.name as gender FROM person p JOIN gender g ON p.gender = g.id");
			
			while(result.next()) {
				Person person = new Person(
					result.getInt("id"),
					result.getString("name"),
					result.getString("birthdate"),
					Gender.valueOf(result.getString("gender"))
				);
				
				person.setFriends( this.getFriends(person) );

				persons.add(person);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return persons;
	}
	
	public Person find(Integer id) {
		Person person = null;
		
		try {
			ResultSet result = this.db.executeQuery("SELECT p.id, p.name, p.birthdate, g.name as gender FROM person p JOIN gender g ON p.gender = g.id WHERE p.id = " + id);
			
			while(result.next()) {
				person = new Person(
					result.getInt("id"),
					result.getString("name"),
					result.getString("birthdate"),
					Gender.valueOf(result.getString("gender"))
				);
				
				person.setFriends( this.getFriends(person) );
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return person;
	}
	
	public Person findByName(String name) {
		Person person = null;
		
		try {
			String sql = "SELECT p.id, p.name, p.birthdate, g.name as gender FROM person p JOIN gender g ON p.gender = g.id WHERE p.name = ?";
			PreparedStatement stmt = this.db.prepareQuery(sql);
			stmt.setString(1, name);
			
			ResultSet result = stmt.executeQuery(); // this.db.executeQuery();
			
			while(result.next()) {
				person = new Person(
					result.getInt("id"),
					result.getString("name"),
					result.getString("birthdate"),
					Gender.valueOf(result.getString("gender"))
				);
				
//				System.out.println(person.toString());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return person;
	}
	
	public void create(Person person) {
		//TODO insert new person;
	}
	
	public Person update(Person person) {
		//TODO update existing person;
		return null;
	}
	
	public boolean delete(Person person) {
		//TODO update existing person;
		return false;
	}
	
	public List<Person> getFriends(Person person) {
		//TODO list friends of a person;
//		return null;
		List<Person> friends = new ArrayList<Person>();
		String sql = "SELECT f1.id, f1.name, f1.birthdate, g.name as gender " + 
				"FROM person p1 " + 
				"JOIN person_has_friends fr1 ON p1.id = fr1.person_id " + 
				"JOIN person f1 ON f1.id = fr1.friend_id " + 
				"JOIN gender g ON p1.gender = g.id " + 
				"WHERE p1.id = ?";
		
		try {
			PreparedStatement stmt = this.db.prepareQuery(sql);
			stmt.setInt(1, person.getId());
			
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				person = new Person(
					result.getInt("id"),
					result.getString("name"),
					result.getString("birthdate"),
					Gender.valueOf(result.getString("gender"))
				);
				
				friends.add(person);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return friends;
	}
	
	public List<Person> getMutualFriends(Person person, Person friend) {
		//TODO list mutual friends of a person;
		person.setFriends(this.getFriends(person));
		friend.setFriends(this.getFriends(friend));
		
		return person.getMutualFriends(friend);
	}
	
	public List<Person> addFriends(Person person, Person... friends) {
		//TODO add multiple friends to a person;
		// return null;
		List<Person> newFriends = new ArrayList<Person>();
		
		try {
			if (person == null) throw new Exception("Person cannot be null.");
			for (Person friend: friends) {
				if (person.equals(friend)) throw new Exception("You cannot befriend yourself.");
				if (person.getFriends().contains(friend)) throw new Exception("You and " + friend.getName() + " are already friends.");
				
				String sql = "INSERT INTO person_has_person VALUES (?, ?)";
				PreparedStatement stmt = this.db.prepareQuery(sql);
				stmt.setInt(1, person.getId());
				stmt.setInt(2, friend.getId());
				
				int affectedRows = stmt.executeUpdate();
				
				if (affectedRows > 0) {
					person.getFriends().add(friend);
					newFriends.add(friend);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return newFriends;
		}
		
		return newFriends;
	}
	
	public boolean unfriend(Person person, Person friend) {
		//TODO remove a friend from a person;
		// return false;
		
		boolean state = false;
		
		try {
			if (person == null || friend == null) throw new Exception("Person and friend cannot be null.");
			if (person.equals(friend)) throw new Exception("You cannot unfriend yourself.");
			if (!person.getFriends().contains(friend)) throw new Exception("You and " + friend.getName() + " weren't friends.");
			
			String sql = "DELETE FROM person_has_person WHERE person_id = ? AND friend_id1 = ?";
			PreparedStatement stmt = this.db.prepareQuery(sql);
			
			stmt.setInt(1, person.getId());
			stmt.setInt(2, friend.getId());
			
			int affectedRows = stmt.executeUpdate();
			
			state = (affectedRows > 0);
			
			if (state) {
				person.getFriends().remove(friend);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return state;
	}
}
