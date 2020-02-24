package com.enigmacomp.entities;

import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "times")
public class Times {
	
	@Id
	private Integer id;
	
	@Column(name = "tayang")
	private Time tayang;
	
	@OneToMany
	@JsonIgnore
	List<JamTayang> listTayang;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Time getTayang() {
		return tayang;
	}

	public void setTayang(Time tayang) {
		this.tayang = tayang;
	}

	public List<JamTayang> getListTayang() {
		return listTayang;
	}

	public void setListTayang(List<JamTayang> listTayang) {
		this.listTayang = listTayang;
	}
	
	
	
}
