package com.enimgacamp.laundry.db.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.hibernate.Transaction;

import com.enigmacamp.laundry.db.entities.LaundryItems;

public class LaundryItemsRepository extends Repository<LaundryItems> {

	public LaundryItemsRepository() {
		this.entity = this.query.from(LaundryItems.class);
	}

	
	public List<LaundryItems> findAll(Predicate... predicates) {
		CriteriaQuery<LaundryItems> cq = this.query.select(this.entity);
		cq.where(predicates);

		return this.executeQuery(cq).getResultList();
	}
	
	public LaundryItems find(Integer id) {
		return session.get(LaundryItems.class, id);
	}
	
	public List<LaundryItems> findByName (String name) {
		CriteriaQuery<LaundryItems> find = this.query.select(this.entity);
		find.where(this.getCriteriaBuilder().equal(this.entity.get("name"), name));

		return this.executeQuery(find).getResultList();
		
	}
	
	
	public LaundryItems addItem (LaundryItems item){
		
		Transaction trx = this.session.beginTransaction();

		Integer id = (Integer) this.session.save(item);
		item = this.find(id);
		trx.commit();

		
		System.out.println("Added Success");
		return item;
	}
	
	
	
	public LaundryItems update (LaundryItems item){
		
		Transaction trx = this.session.beginTransaction();

		this.session.merge(item);
		this.session.getTransaction();
		trx.commit();
		
		System.out.println("Update Success");
		return item;
		
	}
	
	
	
	public void delete(LaundryItems items) {
		
		try {
			Transaction trx = this.session.beginTransaction();
			
			this.session.delete(items);

			trx.commit();
			
			System.out.println("Removed  : "+ items.getJenisCucian());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Delete Failed");
		}
	
	}
	
	
	
	
	
	
}
