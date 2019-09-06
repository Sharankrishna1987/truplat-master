package com.truplat.common.data;

import java.io.Serializable;
import java.util.List;

public class VehicleResponse implements Serializable {

	private static final long serialVersionUID = 6804155743435976941L;
	
	private String make;	
	private List<String> models;

	@SuppressWarnings("unused")
	private VehicleResponse() {
	}

	public VehicleResponse(String make, List<String> models) {
		super();
		this.make = make;
		this.models = models;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public List<String> getModels() {
		return models;
	}

	public void setModels(List<String> models) {
		this.models = models;
	}

	

}
