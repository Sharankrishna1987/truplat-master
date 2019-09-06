package com.truplat.common.data;

import java.io.Serializable;

public class OrganizationResponse implements Serializable {

	private static final long serialVersionUID = 6804155743435976941L;
	
	private Long id;
	private String name;

	@SuppressWarnings("unused")
	private OrganizationResponse() {
	}

	public OrganizationResponse(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
