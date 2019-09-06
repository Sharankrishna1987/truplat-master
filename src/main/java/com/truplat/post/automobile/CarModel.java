package com.truplat.post.automobile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CarModel {
	
	@Id
	private Integer id;
	private String model;
	@ManyToOne
	@JoinColumn(name = "car_make_id")
	private CarMake carMake;

	@SuppressWarnings("unused")
	private CarModel(){}

	public CarModel(Integer id, String model, CarMake carMake) {
		this.id = id;
		this.model = model;
		this.carMake = carMake;
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

	public CarMake getCarMake() {
		return carMake;
	}

	public void setCarMake(CarMake carMake) {
		this.carMake = carMake;
	}

	
	
}
