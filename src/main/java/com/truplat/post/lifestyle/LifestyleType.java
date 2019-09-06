package com.truplat.post.lifestyle;

public enum LifestyleType {
	
	SOFA_DINING("1", "Sofa & Dining"),
	BEDS_WARDROBES("2", "Beds & Wardrobes"),
	HOME_DECOR("3", "Home Decor"),
	GAMES_TOYS("4", "Games & Toys"),
	SPORTS("5", "Sports"),
	Books("6", "Books"),
	FASHION("7", "Fashion"),
	OTHERS("8", "Others");
	
	private String id;
	private String name;
	
	private LifestyleType(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static String getName(String id) {
		for(LifestyleType type : LifestyleType.values()){
			if(type.id.equals(id)) {
				return type.name;
			}
		}
		return null;
	}
	
	

}
