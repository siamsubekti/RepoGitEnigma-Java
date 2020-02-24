package com.enigmacamp.friends.person;

import java.util.List;
import java.util.Objects;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.enigmacamp.friends.enums.Gender;

public class Person {
	private Integer id;
	private String name;
	private Date birthdate;
	private Gender gender;
	
	private List<Person> friends = new ArrayList<Person>();
	
	public Person() {};
	
	public Person(int id, String name, String birthdate, Gender gender) throws ParseException {
		this.id = id;
		this.name = name;
		this.birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
		this.gender = gender;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public void setBirthdate(String birthdate) throws ParseException {
		this.birthdate = new SimpleDateFormat("yyyy-MM-dd").parse(birthdate);
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<Person> getFriends() {
		return friends;
	}

	public void setFriends(List<Person> friends) {
		this.friends = friends;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode("PERSON-" + id + name + gender);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return Objects.equals(hashCode(), obj.hashCode());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PERSON: [id:" + id + ", name: " + name + ", birthdate : "+ getBirthdate() + ", gender: " + gender + "]";
	}
	
	private boolean isAFriend(Person person) {
		return this.friends.contains(person);
	}
	
	public boolean removeFriend(Person friend) {
		if (this.isAFriend(friend)) {
			return this.friends.remove(friend);
		}
		
		return false;
	}
	
	public Person addFriend(Person friend) {
		if (!this.isAFriend(friend) && !this.equals(friend)) {
			this.friends.add(friend);
			
			return friend;
		}
		
		return null;
	}
	
	public List<Person> addFriends(Person... friends) {
		List<Person> addedFriends = new ArrayList<Person>();
		
		for(int n = 0; n < friends.length; n++) {
			Person friend = addFriend(friends[n]);
			
			addedFriends.add(friend);
		}
		
		return addedFriends;
	}

	
	public List<Person> getMutualFriends(Person friend) {
		List<Person> mutualFriends = friend.getFriends();
		
		mutualFriends.retainAll(friends);
		
		return mutualFriends;
	}
}
