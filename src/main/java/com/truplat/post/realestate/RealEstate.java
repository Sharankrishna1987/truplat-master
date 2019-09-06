package com.truplat.post.realestate;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.truplat.usermanagement.User;

@Entity
public class RealEstate {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private String transactionType;
	private String propertyType;
	private String unitType;
	private String locality;
	private String city;
	private String area;
	private String amount;
	private String title;
	private String description;
	private String imageName1;
	private String imageName2;
	private String imageName3;
	private String imageName4;
	private String imageName5;
	@ManyToOne
	@JoinColumn(name="user_id")  
	private User user;
	private boolean deleted; 
	private Date modifiedDate;	
	
	@SuppressWarnings("unused")
	private RealEstate(){}

	public RealEstate(Integer id, String transactionType, String propertyType, String unitType, String locality,
			String city, String area, String amount, String title, String description, String imageName1,
			String imageName2, String imageName3, String imageName4, String imageName5, User user, boolean deleted, Date modifiedDate) {
		super();
		this.id = id;
		this.transactionType = transactionType;
		this.propertyType = propertyType;
		this.unitType = unitType;
		this.locality = locality;
		this.city = city;
		this.area = area;
		this.amount = amount;
		this.title = title;
		this.description = description;
		this.imageName1 = imageName1;
		this.imageName2 = imageName2;
		this.imageName3 = imageName3;
		this.imageName4 = imageName4;
		this.imageName5 = imageName5;
		this.user = user;
		this.deleted = deleted;
		this.modifiedDate = modifiedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getImageName1() {
		return imageName1;
	}

	public void setImageName1(String imageName1) {
		this.imageName1 = imageName1;
	}

	public String getImageName2() {
		return imageName2;
	}

	public void setImageName2(String imageName2) {
		this.imageName2 = imageName2;
	}

	public String getImageName3() {
		return imageName3;
	}

	public void setImageName3(String imageName3) {
		this.imageName3 = imageName3;
	}

	public String getImageName4() {
		return imageName4;
	}

	public void setImageName4(String imageName4) {
		this.imageName4 = imageName4;
	}

	public String getImageName5() {
		return imageName5;
	}

	public void setImageName5(String imageName5) {
		this.imageName5 = imageName5;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}