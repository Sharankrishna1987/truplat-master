package com.truplat.post.realestate;

public enum PropertyType {
	
	APARTMENT("Apartment", "apartment"),
	HOUSE("House", "house");
	
	private String label;
	private String value;
	
	private PropertyType(String label, String value) {
		this.label = label;
		this.value = value;
	}
	
	public static String getLabel(String value) {
		for(PropertyType transactionType : PropertyType.values()){
			if(transactionType.value.equals(value)) {
				return transactionType.label;
			}
		}
		return null;
	}
}
