package com.enigmacomp.entities;


import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="transaksi")
public class Transaksi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="jumlah_tiket")
	private Integer jumlah;
	
	@Column(name="harga_total")
	private Integer total;
	
	@Column
	private Date tanggal;
	
	@ManyToOne
//	@JsonIgnore
	@JoinColumn(name = "jam_tayang_id")
	JamTayang trxJamTayang;
	
	@ManyToOne
//	@JsonIgnore
	@JoinColumn(name = "tiket_id")
	Tiket trxTiket;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getJumlah() {
		return jumlah;
	}
	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Date getTanggal() {
		return tanggal;
	}
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}
	public JamTayang getTrxJamTayang() {
		return trxJamTayang;
	}
	public void setTrxJamTayang(JamTayang trxJamTayang) {
		this.trxJamTayang = trxJamTayang;
	}
	public Tiket getTrxTiket() {
		return trxTiket;
	}
	public void setTrxTiket(Tiket trxTiket) {
		this.trxTiket = trxTiket;
	}
	
	
	
	
}
