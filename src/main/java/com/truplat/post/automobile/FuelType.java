package com.truplat.post.automobile;

public enum FuelType {
	
	PETROL("Petrol", "petrol"),
	DIESEL("Diesel", "diesel"),
	CNG("CNG", "cng"),
	LPG("LPG", "lpg"),
	ELECTRIC("Electric", "electric");
	
	private String label;
	private String value;
	
	private FuelType(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
	public static String getLabel(String value) {
		for(FuelType transactionType : FuelType.values()){
			if(transactionType.value.equals(value)) {
				return transactionType.label;
			}
		}
		return null;
	}
}
