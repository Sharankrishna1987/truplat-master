package com.truplat.usermanagement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserCredential {

	@Id
	private Integer userId;
	@JsonIgnore
	private String passWord;
	private boolean active;
	@JsonIgnore
	private String activationCode;
	private Date activationTime;
	@JsonIgnore
	private int retry;
	@Transient
	private String personalEmailAddress;
	
	@SuppressWarnings("unused")
	private UserCredential() {
	}

	public UserCredential(Integer userId, String passWord, boolean active, String activationCode) {
		this.userId = userId;
		this.passWord = passWord;
		this.active = active;
		this.activationCode = activationCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public Date getActivationTime() {
		return activationTime;
	}

	public void setActivationTime(Date activationTime) {
		this.activationTime = activationTime;
	}

	public int getRetry() {
		return retry;
	}

	public void setRetry(int retry) {
		this.retry = retry;
	}

	public String getPersonalEmailAddress() {
		return personalEmailAddress;
	}

	public void setPersonalEmailAddress(String personalEmailAddress) {
		this.personalEmailAddress = personalEmailAddress;
	}
	
	
	
}