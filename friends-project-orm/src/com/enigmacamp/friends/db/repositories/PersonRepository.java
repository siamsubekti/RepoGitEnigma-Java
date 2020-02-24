package com.enigmacamp.friends.db.repositories;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.enigmacamp.friends.db.entities.Person;

public class PersonRepository extends Repository<Person> {
	public PersonRepository() {
		this.entity = this.query.from(Person.class);
	}
	
	public List<Person> findAll(Predicate... predicates) {
		CriteriaQuery<Person> cq = this.query.select(this.entity);
		cq.where(predicates);
		
		return this.executeQuery(cq).getResultList();
	}
	
	public Person find(Integer id) {
		return (Person) session.get(Person.class, id);
	}
	
//	public Person create (int id, String name, String birthdate, int gender) {
//		
//		Transaction transaction = null;
//		
//			transaction = session.beginTransaction();
//			
//			String hql = "INSERT INTO Person (id, name, birthdate, gender) " + "SELECT id, name, birthdate, gender";
//			Query query = session.createQuery(hql);
//			int result = query.executeUpdate();
//			System.out.println("Row affected: " + result);
//			
//			transaction.commit();
//			
//		
//		return (Person) transaction;
//	}

	
}
