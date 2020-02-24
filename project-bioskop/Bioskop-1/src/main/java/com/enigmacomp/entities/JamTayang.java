package com.enigmacomp.entities;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="jam_tayang")
public class JamTayang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Integer kuota;
	
	@ManyToOne
	@JoinColumn(name = "film_id")
	Film filmId;
	
	@ManyToOne
	@JoinColumn(name = "studio_id")
	Studio studioId;
	
	@ManyToOne
	@JoinColumn(name = "times_id")
	Times TimesId;
	
	public Integer getKuota() {
		return kuota;
	}
	public void setKuota(Integer kuota) {
		this.kuota = kuota;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Film getFilmId() {
		return filmId;
	}
	public void setFilmId(Film filmId) {
		this.filmId = filmId;
	}
	public Studio getStudioId() {
		return studioId;
	}
	public void setStudioId(Studio studioId) {
		this.studioId = studioId;
	}
	public Times getTimesId() {
		return TimesId;
	}
	public void setTimesId(Times timesId) {
		TimesId = timesId;
	}
	
	
	
	
	
	
	
}
