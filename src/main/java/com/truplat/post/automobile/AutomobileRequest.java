package com.truplat.post.automobile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.truplat.common.validator.AmountValid;
import com.truplat.common.validator.CityValid;
import com.truplat.post.automobile.validator.AutomobileLocalityValid;
import com.truplat.post.automobile.validator.AutomobileMakeModelValid;
import com.truplat.post.automobile.validator.FuelTypeValid;
import com.truplat.post.automobile.validator.VehicleTypeValid;
import com.truplat.post.realestate.validator.AreaValid;

@AutomobileLocalityValid(message="Locality is invalid")
@AutomobileMakeModelValid(message="Make or Model is invalid")
public class AutomobileRequest {

	@NotNull
	@Size(min = 1, max = 10, message = "Vehicle Type should be between 1-10 characters")
	@VehicleTypeValid
	private String vehicleType;

	@NotNull
	@Size(min = 1, max = 10, message = "Fuel Type should be between 1-10 characters")
	@FuelTypeValid
	private String fuelType;

	@NotNull
	@Size(min = 1, max = 20, message = "Make should be between 1-20 characters")
	private String make;
	
	@NotNull
	@Size(min = 1, max = 20, message = "Model should be between 1-20 characters")
	private String model;

	@NotNull
	@Size(min = 1, max = 50, message = "Locality should be between 1-50 characters")
	private String locality;

	@NotNull
	@Size(min = 1, max = 25, message = "City should be between 1-25 characters")
	@CityValid
	private String city;

	@NotNull
	@Size(min = 1, max = 6, message = "Area should be between 1-6 characters")
	@AreaValid
	private String driven;

	@NotNull
	@Size(min = 1, max = 8, message = "Amount should be between 1-8 characters")
	@AmountValid
	private String amount;

	@NotNull
	@Size(min = 1, max = 100, message = "Title should be between 1-100 characters")
	private String title;

	@NotNull
	@Size(min = 1, max = 1000, message = "Description should be between 1-1000 characters")
	private String description;
	
	@SuppressWarnings("unused")
	private AutomobileRequest() {
	}

	public AutomobileRequest(
			@NotNull @Size(min = 1, max = 10, message = "Vehicle Type should be between 1-10 characters") String vehicleType,
			@NotNull @Size(min = 1, max = 10, message = "Fuel Type should be between 1-10 characters") String fuelType,
			@NotNull @Size(min = 1, max = 20, message = "Make should be between 1-20 characters") String make,
			@NotNull @Size(min = 1, max = 20, message = "Model should be between 1-20 characters") String model,
			@NotNull @Size(min = 1, max = 25, message = "Locality should be between 1-25 characters") String locality,
			@NotNull @Size(min = 1, max = 25, message = "City should be between 1-25 characters") String city,
			@NotNull @Size(min = 1, max = 6, message = "Area should be between 1-6 characters") String driven,
			@NotNull @Size(min = 1, max = 8, message = "Amount should be between 1-8 characters") String amount,
			@NotNull @Size(min = 1, max = 100, message = "Title should be between 1-100 characters") String title,
			@NotNull @Size(min = 1, max = 1000, message = "Description should be between 1-1000 characters") String description) {
		super();
		this.vehicleType = vehicleType;
		this.fuelType = fuelType;
		this.make = make;
		this.model = model;
		this.locality = locality;
		this.city = city;
		this.driven = driven;
		this.amount = amount;
		this.title = title;
		this.description = description;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDriven() {
		return driven;
	}

	public void setDriven(String driven) {
		this.driven = driven;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}