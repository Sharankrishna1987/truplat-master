package com.truplat.post.automobile;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CarMake {
	
	@Id
	private Integer id;
	private String make;	
	private boolean active; 
    @OneToMany(mappedBy = "carMake")
    private List<CarModel> carModels = new ArrayList<CarModel>();
	
    @SuppressWarnings("unused")
	private CarMake(){}

	public CarMake(Integer id, String make, boolean active, List<CarModel> carModels) {
		this.id = id;
		this.make = make;
		this.active = active;
		this.carModels = carModels;
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

	public List<CarModel> getCarModels() {
		return carModels;
	}

	public void setCarModels(List<CarModel> carModels) {
		this.carModels = carModels;
	}

}
