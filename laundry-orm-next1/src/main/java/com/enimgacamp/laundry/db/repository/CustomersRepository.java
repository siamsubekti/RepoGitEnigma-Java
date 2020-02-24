package com.enimgacamp.laundry.db.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.hibernate.Transaction;

import com.enigmacamp.laundry.db.entities.Customers;

public class CustomersRepository  extends Repository<Customers>{
	
	public CustomersRepository() {
		this.entity = this.query.from(Customers.class);
	}

	
	public List<Customers> findAll(Predicate... predicates) {
		CriteriaQuery<Customers> cq = this.query.select(this.entity);
		cq.where(predicates);

		return this.executeQuery(cq).getResultList();
	}
	
	public Customers find(Integer id) {
		return session.get(Customers.class, id);
	}
	
	public List<Customers> findByName (String name) {
		CriteriaQuery<Customers> find = this.query.select(this.entity);
		find.where(this.getCriteriaBuilder().equal(this.entity.get("name"), name));

		return this.executeQuery(find).getResultList();
		
	}
	
	
	public Customers addCustom (Customers person){
		
		Transaction trx = this.session.beginTransaction();

		Integer id = (Integer) this.session.save(person);
		person = this.find(id);
		trx.commit();

		
		System.out.println("Added Success");
		return person;
	}
	
	
	
	public Customers update (Customers person){
		
		Transaction trx = this.session.beginTransaction();

		this.session.merge(person);
		this.session.getTransaction();
		trx.commit();
		
		System.out.println("Update Success");
		return person;
		
	}
	
	
	
	public void delete(Customers person) {
		
		try {
			Transaction trx = this.session.beginTransaction();
			
			this.session.delete(person);

			trx.commit();
			
			System.out.println("Removed  : "+ person.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Delete Failed");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
