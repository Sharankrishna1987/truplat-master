package com.truplat.common.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Organization implements Serializable {

	@Id
	private Long id;
	private String name;
	private String emailDomain;
	private boolean active;

	@SuppressWarnings("unused")
	private Organization() {
	}

	public Organization(Long id, String name, String emailDomain, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.emailDomain = emailDomain;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
