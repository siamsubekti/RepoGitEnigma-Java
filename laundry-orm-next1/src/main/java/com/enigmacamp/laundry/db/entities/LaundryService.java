package com.enigmacamp.laundry.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "laundry_service")
public class LaundryService {
	@Id
	private Integer id;
	
	@Column
	private String name;
	
	@Column(name = "harga_service")
	private Double hargaService;
	
	@OneToMany
	
	
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
	public Double getHargaService() {
		return hargaService;
	}
	public void setHargaService(Double hargaService) {
		this.hargaService = hargaService;
	}
	@Override
	public String toString() {
		return "LaundryService [id=" + id + ", name=" + name + ", hargaService=" + hargaService + "]";
	}
	
	
	
	
	
}
