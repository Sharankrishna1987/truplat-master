package com.truplat.usermanagement;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.truplat.common.validator.CityValid;


public class UpdateUserRequest {
	
	@NotNull @Size(min=1,max=25, message="First name should be between 1-25 characters")
	private String firstName;
	@NotNull @Size(min=1,max=25, message="Last name should be between 1-25 characters")
	private String lastName;
	@NotNull
	private String gender;
	@NotNull 
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dob;
	@NotNull @Size(min=1,max=50, message="Personal email address should be between 1-50 characters") @Email(message = "Personal email address is invalid")
	private String personalEmailAddress;
	@NotNull @Size(min=1,max=25, message="Contact number should be between 1-25 characters")
	private String contactNumber;	
	@CityValid
	private String city;
	@NotNull @Size(min=1,max=10, message="Pincode should be between 1-10 characters")
	private String pincode;
	@NotNull @Size(min=1,max=5, message="Pincode should be between 1-5 characters")
	private String restrictedAccess;
	
	@SuppressWarnings("unused")
	private UpdateUserRequest(){}

	public UpdateUserRequest(
			@NotNull @Size(min = 1, max = 25, message = "First name should be between 1-25 characters") String firstName,
			@NotNull @Size(min = 1, max = 25, message = "Last name should be between 1-25 characters") String lastName,
			@NotNull String gender, @NotNull String dob,
			@NotNull @Size(min = 1, max = 50, message = "Personal email address should be between 1-50 characters") @Email(message = "Personal email address is invalid") String personalEmailAddress,
			@NotNull @Size(min = 1, max = 25, message = "Contact number should be between 1-25 characters") String contactNumber,
			String city,
			@NotNull @Size(min = 1, max = 10, message = "Pincode should be between 1-10 characters") String pincode,
			@NotNull @Size(min = 1, max = 5, message = "Pincode should be between 1-5 characters") String restrictedAccess) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.personalEmailAddress = personalEmailAddress;
		this.contactNumber = contactNumber;
		this.city = city;
		this.pincode = pincode;
		this.restrictedAccess = restrictedAccess;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPersonalEmailAddress() {
		return personalEmailAddress;
	}

	public void setPersonalEmailAddress(String personalEmailAddress) {
		this.personalEmailAddress = personalEmailAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getRestrictedAccess() {
		return restrictedAccess;
	}

	public void setRestrictedAccess(String restrictedAccess) {
		this.restrictedAccess = restrictedAccess;
	}

}
