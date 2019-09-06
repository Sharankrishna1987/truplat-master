package com.truplat.usermanagement;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.truplat.common.data.Organization;

@Entity
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String firstName;
	private String lastName;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String personalEmailAddress;
	private String officialEmailAddress;
	private String contactNumber;
	private String city;
	private String pincode;
	private String restrictedAccess;
	private boolean active; 
	private String modifiedBy;
	private Date modifiedDate;	
	@ManyToOne
	private Organization organization;
	
	@SuppressWarnings("unused")
	private User(){}
	
	public User(Integer userId, String firstName, String lastName, String gender, Date dob, String personalEmailAddress,
			String officialEmailAddress, String contactNumber, String city, String pincode, String restrictedAccess, boolean active, String createdBy, 
			Date createdDate, String modifiedBy, Date modifiedDate, Organization organization) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.personalEmailAddress = personalEmailAddress;
		this.officialEmailAddress = officialEmailAddress;
		this.contactNumber = contactNumber;
		this.city = city;
		this.pincode = pincode;	
		this.restrictedAccess = restrictedAccess;
		this.active = active;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.organization = organization;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPersonalEmailAddress() {
		return personalEmailAddress;
	}

	public void setPersonalEmailAddress(String personalEmailAddress) {
		this.personalEmailAddress = personalEmailAddress;
	}

	public String getOfficialEmailAddress() {
		return officialEmailAddress;
	}

	public void setOfficialEmailAddress(String officialEmailAddress) {
		this.officialEmailAddress = officialEmailAddress;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
}