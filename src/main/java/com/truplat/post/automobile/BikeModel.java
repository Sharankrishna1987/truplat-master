package com.truplat.post.automobile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BikeModel {
	
	@Id
	private Integer id;
	private String model;
	@ManyToOne
	@JoinColumn(name = "bike_make_id")
	private BikeMake bikeMake;

	@SuppressWarnings("unused")
	private BikeModel(){}

	public BikeModel(Integer id, String model, BikeMake bikeMake) {
		this.id = id;
		this.model = model;
		this.bikeMake = bikeMake;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BikeMake getBikeMake() {
		return bikeMake;
	}

	public void setBikeMake(BikeMake bikeMake) {
		this.bikeMake = bikeMake;
	}
	
	
}
