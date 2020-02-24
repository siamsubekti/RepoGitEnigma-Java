package com.enigmacamp.friends.db.models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.enigmacamp.friends.db.Database;
import com.enigmacamp.friends.enums.Gender;
import com.enigmacamp.friends.person.Person;

public class PersonModel {
	private Database db = new Database();
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();	
		
		try {
		ResultSet result = this.db.executeQuery("SELECT p.id, p.name, p.birthdate, g.name as gender FROM person p JOIN gender g ON p.gender_id = g.id order by id asc");
			
			while(result.next()) {
				Person person = new Person(
					result.getInt("id"),
					result.getString("name"),
					result.getString("birthdate"),
					Gender.valueOf(result.getString("gender"))
				);

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
		String selectQuery = "SELECT p.id, p.name, p.birthdate, g.name as gender FROM person p JOIN gender g ON p.gender_id = g.id WHERE p.id = ?";
		
		PreparedStatement stmt = this.db.prepareStatement(selectQuery);
		stmt.setInt(1, id);
		
		ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				person = new Person(
					result.getInt("id"),
					result.getString("name"),
					result.getString("birthdate"),
					Gender.valueOf(result.getString("gender"))
				);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return person;
	}
	
	
	public void create(Person person) {
		String date = format.format(person.getBirthdate());
		Person check = this.find(person.getId());
		if (check == null) {
				
		int gender;
		if (person.getGender() == Gender.Male) {
			gender = 1;
		} else {
			gender = 2;
		}
		
		try {
			
			String insertQuery = "INSERT INTO person (id,name, birthdate, gender_id) VALUES (? , ? , ?, ?)";
			PreparedStatement stmt = this.db.prepareStatement(insertQuery);
			stmt.setInt(1, person.getId());
			stmt.setString(2, person.getName());
			stmt.setString(3, date);
			stmt.setInt(4, gender);
			
			
			stmt.executeUpdate();
			System.out.println(stmt != null ? "succes add person" : "failed");			
			
			}
			catch (Exception e) {
			e.printStackTrace();
		
		} 
		
	} else {
		System.out.println("Data sudah di tambahkan");
	}
}
	
	public Person update(Person person) {
		String date = format.format(person.getBirthdate());
		
		int gender;
		if (person.getGender() == Gender.Male) {
			gender = 1;
		} else {
			gender = 2;
		}
		
		
		try {
		 String insertUpdate = ("UPDATE person SET name = ?, birthdate = ?, gender_id = ? WHERE id = ?");
		 PreparedStatement stmt = this.db.prepareStatement(insertUpdate);
		 stmt.setString(1, person.getName());
		 stmt.setString(2, date);
		 stmt.setInt(3, gender);
		 stmt.setInt(4, person.getId());
		 
		 stmt.executeUpdate();
		 
			System.out.println(stmt != null ? "succes" : "failed");

			}
			catch (Exception e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public boolean delete(Person person) throws SQLException {
			
		
		try {
			String delete = ("DELETE from person where id = ?");
			PreparedStatement stm = this.db.prepareStatement(delete);
			stm.setInt(1, person.getId());
			
			boolean del = stm.execute();
			
			System.out.println(del ?" delete succes" : "failed");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return false;
	}
	
	public void PersonAndFriendList () {
		try {
			ResultSet result = this.db.executeQuery("select * from person inner join gender on person.gender_id = gender.id inner join person_has_person on person.id = person_has_person.person_id order by person.id asc");
			
			while (result.next()) {
				System.out.println(
					result.getInt("id")+". "+
					result.getString("name")+","+
					result.getString("birthdate")+",\t friend id : "+
					result.getInt("friend_id1")
//					result.getString("friend_name")
					);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Person> getFriends(Person id) {
		List<Person> persons = new ArrayList<Person>();
		
		try {
			String getFriends = ("select `c`.`id`, `c`.`name`, `c`.`birthdate`, g.name as gender from `person` `a` inner join gender g on a.gender_id = g.id inner join `person_has_person` `b` on`a`.`id`= `b`.`person_id` inner join `person` `c` on `c`.`id` = `b`.`friend_id1` where b.person_id = ?");
			PreparedStatement stm = this.db.prepareStatement(getFriends);
			stm.setInt(1, id.getId());
			
			ResultSet result = stm.executeQuery();
			
			
			while(result.next()) {
				Person person = new Person(
					result.getInt("id"),
					result.getString("name"),
					result.getString("birthdate"),
					Gender.valueOf(result.getString("gender"))
				);

				persons.add(person);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return persons;
	}
	
	public List<Person> getMutualFriends(Person person, Person friend) throws SQLException {
		List<Person> mutual = new ArrayList<Person>();
		
		try {
			String insertmutu = ("select `f1`.`id`, `f1`.`name`, `f1`.`birthdate`, `g`.`name` as gender from `person` `p1` join `person_has_person` `fr1` on `p1`.`id` = `fr1`.`person_id`join `person` `f1` on `f1`.`id` = `fr1`.`friend_id1` join `gender` `g` on `f1`.`gender_id` = `g`.id where `p1`.`id` = ? and `f1`.`id` in (select `f2`.`id` from `person` `p2` join `person_has_person` `fr2` on `p2`.`id` = `fr2`.`person_id`join `person` `f2` on `f2`.`id` = `fr2`.`friend_id1` where `p2`.`id` = ?");
			PreparedStatement stm = this.db.prepareStatement(insertmutu);
			stm.setInt(1, person.getId());
			stm.setInt(2, friend.getId());
			
			ResultSet result = stm.executeQuery();
			
			while(result.next()) {
				Person person2 = new Person(
					result.getInt("id"),
					result.getString("name"),
					result.getString("birthdate"),
//					result.getInt("friend_id1"),
//					result.getString("friend_name"),
					Gender.valueOf(result.getString("gender"))
				);
				mutual.add(person2);
			} 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		return mutual;
	}
	
	public List<Person> addFriends (Person person, Person...friends)throws SQLException, ParseException {
		int i = 0;
		
			try {
				while (i < friends.length) {
					Person check = this.find(person.getId());
					Person check1 = this.find(friends[i].getId());
					
					if(check != null && check1 != null && check.getId() != friends[i].getId()) {
					
					String querySelect = "SELECT * FROM person_has_person where person_id = ? and friend_id1 = ?";
					PreparedStatement stm = this.db.prepareStatement(querySelect);
					stm.setInt(1, person.getId());
					stm.setInt(2, friends[i].getId());
					stm.executeQuery();
					
					ResultSet result = stm.executeQuery();
					
					
					if(!result.next()) {
					String query = "insert into person_has_person (person_id, friend_id1) values (?,?)";
					PreparedStatement stmt = this.db.prepareStatement(query);
					stmt.setInt(1, person.getId());
					stmt.setInt(2, friends[i].getId());
					
					stmt.executeUpdate();
					System.out.println("Id : "+friends[i].getId() + " succes addfriend");
					} else {
						System.out.println( "Teman sudah ada");		
				}	
			}
					else {
			System.out.println(" data sudah di add");
		} i++;
	}
				
			} catch (Exception e) {
				e.printStackTrace();
		}	 
		
		return getFriends(person);
	}
	
	public boolean unfriend(Person person, Person friend) {
		
		boolean state = false;
		
		try {
			if (person == null || friend == null) throw new Exception("Person and friend cannot be null");
			if (person .equals(friend)) throw new Exception("You cannot unfriend yourself");
			if (!person.getFriends().contains(friend)) throw new Exception("You and " + friend.getName() + " weren't friends");
			
			String delete = "DELETE from person_has_person where (person_id = ?) and (friend_id1 = ?";
			PreparedStatement stm = this.db.prepareStatement(delete);
			stm.setInt(1, person.getId());
			stm.setInt(2, friend.getId());
			
			int deleterow = stm.executeUpdate();
			
			state = (deleterow > 0);
			
			if (state) {
				person.getFriends().remove(friend);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Person findByName(String name) {
		Person person = null;
		
		try {
		String sql = "SELECT p.id, p.name, p.birthdate, g.name as gender FROM person p JOIN gender g ON p.gender_id = g.id WHERE p.name = ?";
		
		PreparedStatement stmt = this.db.prepareStatement(sql);
		stmt.setString(1, name);
		ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				person = new Person(
					result.getInt("id"),
					result.getString("name"),
					result.getString("birthdate"),
					Gender.valueOf(result.getString("gender"))
				);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return person;
	}
}



