package com.truplat.post.automobile;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BikeMake {
	
	@Id
	private Integer id;
	private String make;	
	private boolean active; 
    @OneToMany(mappedBy = "bikeMake")
    private List<BikeModel> bikeModels = new ArrayList<BikeModel>();
	
    @SuppressWarnings("unused")
	private BikeMake(){}

	public BikeMake(Integer id, String make, boolean active, List<BikeModel> bikeModels) {
		this.id = id;
		this.make = make;
		this.active = active;
		this.bikeModels = bikeModels;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<BikeModel> getBikeModels() {
		return bikeModels;
	}

	public void setBikeModels(List<BikeModel> bikeModels) {
		this.bikeModels = bikeModels;
	}

    
}
