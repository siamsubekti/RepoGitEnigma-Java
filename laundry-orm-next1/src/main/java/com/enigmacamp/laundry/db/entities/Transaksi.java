package com.enigmacamp.laundry.db.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaksi")
public class Transaksi {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column (name = "total_harga")
	private Double totalHarga;
	
	@Column (name = "tanggal_masuk")
	private Date tanggalMasuk;
	
	@Column
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customerId;
	
	@ManyToOne
	@JoinColumn(name = "laundry_service_id")
	private LaundryService laundryServiceId;
	
	@ManyToMany
	@JoinTable(name = "transaksi_has_laundry_items",
			joinColumns = @JoinColumn(name = "transaksi_id"),
			inverseJoinColumns = @JoinColumn(name = "laundry_items_id"))
	private List<LaundryItems> laundryItems;
	
	
	
	
	
	
}
