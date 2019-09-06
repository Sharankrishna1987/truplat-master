package com.truplat.post.lifestyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.truplat.common.validator.AmountValid;
import com.truplat.common.validator.CityValid;
import com.truplat.post.lifestyle.validator.LifestyleLocalityValid;
import com.truplat.post.lifestyle.validator.LifestyleTypeValid;

@LifestyleLocalityValid(message="Locality is invalid")
public class LifestyleRequest {

	@NotNull
	@Size(min = 1, max = 40, message = "Electronic Type should be between 1-40 characters")
	@LifestyleTypeValid
	private String lifestyleType;

	@NotNull
	@Size(min = 1, max = 50, message = "Locality should be between 1-50 characters")
	private String locality;

	@NotNull
	@Size(min = 1, max = 25, message = "City should be between 1-25 characters")
	@CityValid
	private String city;

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
	private LifestyleRequest() {
	}

	public LifestyleRequest(
			@NotNull @Size(min = 1, max = 40, message = "Electronic Type should be between 1-40 characters") String lifestyleType,
			@NotNull @Size(min = 1, max = 25, message = "Locality should be between 1-25 characters") String locality,
			@NotNull @Size(min = 1, max = 25, message = "City should be between 1-25 characters") String city,
			@NotNull @Size(min = 1, max = 8, message = "Amount should be between 1-8 characters") String amount,
			@NotNull @Size(min = 1, max = 100, message = "Title should be between 1-100 characters") String title,
			@NotNull @Size(min = 1, max = 1000, message = "Description should be between 1-1000 characters") String description) {
		super();
		this.lifestyleType = lifestyleType;
		this.locality = locality;
		this.city = city;
		this.amount = amount;
		this.title = title;
		this.description = description;
	}

	public String getLifestyleType() {
		return lifestyleType;
	}

	public void setLifestyleType(String lifestyleType) {
		this.lifestyleType = lifestyleType;
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