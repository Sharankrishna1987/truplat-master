package com.truplat.common.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {
	
	@Id
	private Integer id;
	private String name;	
	private boolean active; 
    @OneToMany(mappedBy = "city")
    private List<Locality> localities= new ArrayList<Locality>();
	
    @SuppressWarnings("unused")
	private City(){}

	public City(Integer id, String name, boolean active, List<Locality> localities) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.localities = localities;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Locality> getLocalities() {
		return localities;
	}

	public void setLocalities(List<Locality> localities) {
		this.localities = localities;
	}
    
}
