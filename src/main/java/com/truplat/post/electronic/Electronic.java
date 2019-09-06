package com.truplat.post.electronic;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.truplat.usermanagement.User;

@Entity
public class Electronic {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String electronicType;
	private String locality;
	private String city;
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
	private Electronic(){}

	public Electronic(Integer id, String electronicType, String locality, String city, String amount, String title,
			String description, String imageName1, String imageName2, String imageName3, String imageName4,
			String imageName5, User user, boolean deleted, Date modifiedDate) {
		super();
		this.id = id;
		this.electronicType = electronicType;
		this.locality = locality;
		this.city = city;
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

	public String getElectronicType() {
		return electronicType;
	}

	public void setElectronicType(String electronicType) {
		this.electronicType = electronicType;
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