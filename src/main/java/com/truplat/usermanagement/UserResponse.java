package com.truplat.usermanagement;

import com.truplat.common.data.Organization;

public class UserResponse {
	
	private String personalEmailAddress;
	private String firstName;
	private String lastName;
	private Organization organization;
	private String gender;
	private String dob;
	private String contactNumber;	
	private String city;
	private String pincode;
	private String restrictedAccess;
	
	@SuppressWarnings("unused")
	private UserResponse(){}

	public UserResponse(String personalEmailAddress, String firstName, String lastName, Organization organization,
			String gender, String dob, String contactNumber, String city, String pincode, String restrictedAccess) {
		this.personalEmailAddress = personalEmailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.organization = organization;
		this.gender = gender;
		this.dob = dob;
		this.contactNumber = contactNumber;
		this.city = city;
		this.pincode = pincode;
		this.restrictedAccess = restrictedAccess;
	}

	public String getPersonalEmailAddress() {
		return personalEmailAddress;
	}

	public void setPersonalEmailAddress(String personalEmailAddress) {
		this.personalEmailAddress = personalEmailAddress;
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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
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
