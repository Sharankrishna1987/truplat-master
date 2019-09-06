package com.truplat.post.automobile;

public enum VehicleType {
	
	CAR("Car", "car"),
	BIKE("Bike", "bike");
	
	private String label;
	private String value;
	
	private VehicleType(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
	public static String getLabel(String value) {
		for(VehicleType transactionType : VehicleType.values()){
			if(transactionType.value.equals(value)) {
				return transactionType.label;
			}
		}
		return null;
	}

	public String getLabel() {
		return label;
	}

	public String getValue() {
		return value;
	}
	
	
}
