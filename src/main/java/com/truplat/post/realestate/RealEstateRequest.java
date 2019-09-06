package com.truplat.post.realestate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.truplat.common.validator.AmountValid;
import com.truplat.common.validator.CityValid;
import com.truplat.post.realestate.validator.AreaValid;
import com.truplat.post.realestate.validator.PropertyTypeValid;
import com.truplat.post.realestate.validator.RealEstateLocalityValid;
import com.truplat.post.realestate.validator.TransactionTypeValid;
import com.truplat.post.realestate.validator.UnitTypeValid;

@RealEstateLocalityValid(message="Locality is invalid")
public class RealEstateRequest {

	private String userId;

	@NotNull
	@Size(min = 1, max = 10, message = "Transaction Type should be between 1-10 characters")
	@TransactionTypeValid
	private String transactionType;

	@NotNull
	@Size(min = 1, max = 10, message = "Property Type should be between 1-10 characters")
	@PropertyTypeValid
	private String propertyType;

	@NotNull
	@Size(min = 1, max = 10, message = "Unit Type should be between 1-10 characters")
	@UnitTypeValid
	private String unitType;

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
	private String area;

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
	private RealEstateRequest() {
	}

	public RealEstateRequest(String userId,
			@NotNull @Size(min = 1, max = 10, message = "Transaction Type should be between 1-10 characters") String transactionType,
			@NotNull @Size(min = 1, max = 10, message = "Property Type should be between 1-10 characters") String propertyType,
			@NotNull @Size(min = 1, max = 10, message = "Unit Type should be between 1-10 characters") String unitType,
			@NotNull @Size(min = 1, max = 25, message = "Locality should be between 1-25 characters") String locality,
			@NotNull @Size(min = 1, max = 25, message = "City should be between 1-25 characters") String city,
			@NotNull @Size(min = 1, max = 6, message = "Area should be between 1-6 characters") String area,
			@NotNull @Size(min = 1, max = 8, message = "Amount should be between 1-8 characters") String amount,
			@NotNull @Size(min = 1, max = 100, message = "Title should be between 1-100 characters") String title,
			@NotNull @Size(min = 1, max = 1000, message = "Description should be between 1-1000 characters") String description) {
		super();
		this.userId = userId;
		this.transactionType = transactionType;
		this.propertyType = propertyType;
		this.unitType = unitType;
		this.locality = locality;
		this.city = city;
		this.area = area;
		this.amount = amount;
		this.title = title;
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getUnitType() {
		return unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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