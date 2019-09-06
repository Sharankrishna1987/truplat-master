package com.truplat.common;

public enum Category {
	
	REAL_ESTATE(1000),
	AUTOMOBILE(2000),
	ELECTRONIC(3000),
	LIFESTYLE(4000);
	
	private Integer id;
	
	private Category(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public static Category getById(Integer id) {
		for(Category category : Category.values()){
			if(category.id.equals(id)) {
				return category;
			}
		}
		return null;
	}
}
