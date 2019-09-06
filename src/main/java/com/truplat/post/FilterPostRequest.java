package com.truplat.post;

import javax.validation.constraints.Size;

import com.truplat.common.validator.CityValid;

public class FilterPostRequest {

	@Size(min = 1, max = 25, message = "City should be between 1-25 characters")
	@CityValid
	private String city;

	@Size(min = 1, max = 100, message = "Title should be between 1-100 characters")
	private String keywords;
	
	private Integer categoryId;

	@SuppressWarnings("unused")
	private FilterPostRequest() {
	}

	public FilterPostRequest(
			@Size(min = 1, max = 25, message = "City should be between 1-25 characters") String city,
			@Size(min = 1, max = 100, message = "Title should be between 1-100 characters") String keywords,
			Integer categoryId) {
		super();
		this.city = city;
		this.keywords = keywords;
		this.categoryId = categoryId;
	}

	public String getCity() {
		return city;
	}

	public String getKeywords() {
		return keywords;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

}