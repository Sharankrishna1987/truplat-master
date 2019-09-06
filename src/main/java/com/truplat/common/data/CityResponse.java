package com.truplat.common.data;

import java.io.Serializable;
import java.util.List;

public class CityResponse implements Serializable {

	private static final long serialVersionUID = 6804155743435976941L;
	
	private String name;	
	private List<String> localities;

	@SuppressWarnings("unused")
	private CityResponse() {
	}

	public CityResponse(String name, List<String> localities) {
		this.name = name;
		this.localities = localities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getLocalities() {
		return localities;
	}

	public void setLocalities(List<String> localities) {
		this.localities = localities;
	}

}
