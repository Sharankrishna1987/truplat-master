package com.truplat.post.realestate;

public class RealEstateResponse {

	private String id;
	private String transactionType;
	private String propertyType;
	private String unitType;
	private String locality;
	private String city;
	private String area;
	private String amount;
	private String title;
	private String description;
	private String[] images;
	private String postedBy;
	private String organizationName;
	private String contactNumber;
	private String emailAddress;

	@SuppressWarnings("unused")
	private RealEstateResponse() {
	}

	public static class Builder {
		private String id;
		private String transactionType;
		private String propertyType;
		private String unitType;
		private String locality;
		private String city;
		private String area;
		private String amount;
		private String title;
		private String description;
		private String[] images;
		private String postedBy;
		private String organizationName;
		private String contactNumber;
		private String emailAddress;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder transactionType(String transactionType) {
			this.transactionType = transactionType;
			return this;
		}

		public Builder propertyType(String propertyType) {
			this.propertyType = propertyType;
			return this;
		}

		public Builder unitType(String unitType) {
			this.unitType = unitType;
			return this;
		}

		public Builder locality(String locality) {
			this.locality = locality;
			return this;
		}

		public Builder city(String city) {
			this.city = city;
			return this;
		}

		public Builder area(String area) {
			this.area = area;
			return this;
		}

		public Builder amount(String amount) {
			this.amount = amount;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder images(String[] images) {
			this.images = images;
			return this;
		}

		public Builder postedBy(String postedBy) {
			this.postedBy = postedBy;
			return this;
		}

		public Builder organizationName(String organizationName) {
			this.organizationName = organizationName;
			return this;
		}

		public Builder contactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
			return this;
		}

		public Builder emailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
			return this;
		}

		public RealEstateResponse build() {
			return new RealEstateResponse(this);
		}
	}

	private RealEstateResponse(Builder builder) {
		this.id = builder.id;
		this.transactionType = builder.transactionType;
		this.propertyType = builder.propertyType;
		this.unitType = builder.unitType;
		this.locality = builder.locality;
		this.city = builder.city;
		this.area = builder.area;
		this.amount = builder.amount;
		this.title = builder.title;
		this.description = builder.description;
		this.images = builder.images;
		this.postedBy = builder.postedBy;
		this.organizationName = builder.organizationName;
		this.contactNumber = builder.contactNumber;
		this.emailAddress = builder.emailAddress;
	}

	public String getId() {
		return id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public String getUnitType() {
		return unitType;
	}

	public String getLocality() {
		return locality;
	}

	public String getCity() {
		return city;
	}

	public String getArea() {
		return area;
	}

	public String getAmount() {
		return amount;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String[] getImages() {
		return images;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
	
	
}
