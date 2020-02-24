package enigma.secondweek.exercise.arraylist;

import java.util.*;


import HashCode.Person;

public class Person {
	private String nama;
	private int age;
	ArrayList<Person> friends;
	private ArrayList<Person> mutualFriends;
	List<Person> removeFriend;
	List<Person> removeAllFriends;
	
	public Person (String nama, int age, List<Person> friend) {
		this.nama = nama;
		this.age = age;

	}
	
	public void listFriends() {
		if (friends != null) {
			for(Person list : this.friends) {
				System.out.println(list.nama + " is " + this.nama + " friends");
	}
		}

	}
	
	public void addFriends(Person...person) {
		friends = new ArrayList<Person>();
		int i = 0;
		while( i < person.length) {
			friends.add(person[i]);
			System.out.println(this.nama+ " telah berteman dengan " + person[i]); 
			i++;
		}
	}
	
	public void removeFriends(Person...person) {
		friends = new ArrayList<Person>();
		int i = 0;
		while( i < person.length) {
			friends.remove(person[i]);
			System.out.println(person[i] + " unfriends with " + this.nama);
			i++;
		}
	}
	
	public void removeAllFriends(Person...person) {
		int i = 0;
		while(i < person.length) {
		friends.removeAll((Collection<?>) person[i]);
		System.out.println(" is haven't friends " + person[i]);
	}
	}
	
	public void mutualFriend(List<Person> friend) {
		List<Person> mutualFriends = new ArrayList<Person>(friend);
		if (mutualFriends.retainAll(friends)) {
			for(Person mutFr : mutualFriends) {
				mutFr.getNama();
				
			}

			
		}
	}
	
	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public HashSet<Person> mutualFriend(Person person) {
		HashSet<Person> mutualFriends = new HashSet<>();
		int mutual = 0;
		
		for(Person mF : person.friends) {
			for(Person fr : friends) {
				if(fr.equals(mF)) {
					mutualFriends.add(fr);
					mutual++;
				}
			}
		}
		System.out.println(mutual);
		return mutualFriends;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((mutualFriends == null) ? 0 : mutualFriends.hashCode());
		result = prime * result + ((nama == null) ? 0 : nama.hashCode());
		result = prime * result + ((removeAllFriends == null) ? 0 : removeAllFriends.hashCode());
		result = prime * result + ((removeFriend == null) ? 0 : removeFriend.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (mutualFriends == null) {
			if (other.mutualFriends != null)
				return false;
		} else if (!mutualFriends.equals(other.mutualFriends))
			return false;
		if (nama == null) {
			if (other.nama != null)
				return false;
		} else if (!nama.equals(other.nama))
			return false;
		if (removeAllFriends == null) {
			if (other.removeAllFriends != null)
				return false;
		} else if (!removeAllFriends.equals(other.removeAllFriends))
			return false;
		if (removeFriend == null) {
			if (other.removeFriend != null)
				return false;
		} else if (!removeFriend.equals(other.removeFriend))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [nama=" + nama + ", age=" + age + "]";
	}




	
	

}
