package com.enimgacamp.laundry.db.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.hibernate.Transaction;

import com.enigmacamp.laundry.db.entities.LaundryService;

public class LaundryServiceRepository extends Repository<LaundryService>{
	
	public LaundryServiceRepository() {
		this.entity = this.query.from(LaundryService.class);
	}

	
	public List<LaundryService> findAll(Predicate... predicates) {
		CriteriaQuery<LaundryService> cq = this.query.select(this.entity);
		cq.where(predicates);

		return this.executeQuery(cq).getResultList();
	}
	
	public LaundryService find(Integer id) {
		return session.get(LaundryService.class, id);
	}
	
	public List<LaundryService> findByName (String name) {
		CriteriaQuery<LaundryService> find = this.query.select(this.entity);
		find.where(this.getCriteriaBuilder().equal(this.entity.get("name"), name));

		return this.executeQuery(find).getResultList();
		
	}
	
	
	public LaundryService addService (LaundryService service){
		
		Transaction trx = this.session.beginTransaction();

		Integer id = (Integer) this.session.save(service);
		service = this.find(id);
		trx.commit();

		
		System.out.println("Added Success");
		return service;
	}
	
	
	
	public LaundryService update (LaundryService service){
		
		Transaction trx = this.session.beginTransaction();

		this.session.merge(service);
		this.session.getTransaction();
		trx.commit();
		
		System.out.println("Update Success");
		return service;
		
	}
	
	
	
	public void delete(LaundryService service) {
		
		try {
			Transaction trx = this.session.beginTransaction();
			
			this.session.delete(service);

			trx.commit();
			
			System.out.println("Removed  : "+ service.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Delete Failed");
		}
	}

}
