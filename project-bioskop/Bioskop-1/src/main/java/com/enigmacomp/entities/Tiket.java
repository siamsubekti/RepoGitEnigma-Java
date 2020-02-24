package com.enigmacomp.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tiket")
public class Tiket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nama")
	private String name;
	
	@Column
	private Integer harga;
	
//	@OneToMany
//	@JsonIgnore
//	List<Transaksi> listTiket;
	
	
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
	public Integer getHarga() {
		return harga;
	}
	public void setHarga(Integer harga) {
		this.harga = harga;
	}
//	public List<Transaksi> getListTiket() {
//		return listTiket;
//	}
//	public void setListTiket(List<Transaksi> listTiket) {
//		this.listTiket = listTiket;
//	}
	
	
}
