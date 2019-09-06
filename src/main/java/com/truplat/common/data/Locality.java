package com.truplat.common.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Locality {
	
	@Id
	private Integer id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@SuppressWarnings("unused")
	private Locality(){}
	
	public Locality(Integer id, String name, City city) {
		this.id = id;
		this.name = name;
		this.city = city;
	}

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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
}
