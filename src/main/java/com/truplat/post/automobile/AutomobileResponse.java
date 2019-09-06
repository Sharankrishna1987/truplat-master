package com.truplat.post.automobile;

public class AutomobileResponse {

	private String id;
	private String vehicleType;
	private String fuelType;
	private String make;
	private String model;
	private String locality;
	private String city;
	private String driven;
	private String amount;
	private String title;
	private String description;
	private String[] images;
	private String postedBy;
	private String organizationName;
	private String contactNumber;
	private String emailAddress;

	private AutomobileResponse() {
	}

	public static class Builder {
		private String id;
		private String vehicleType;
		private String fuelType;
		private String make;
		private String model;
		private String locality;
		private String city;
		private String driven;
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

		public Builder vehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
			return this;
		}

		public Builder fuelType(String fuelType) {
			this.fuelType = fuelType;
			return this;
		}

		public Builder make(String make) {
			this.make = make;
			return this;
		}

		public Builder model(String model) {
			this.model = model;
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

		public Builder driven(String driven) {
			this.driven = driven;
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

		public AutomobileResponse build() {
			return new AutomobileResponse(this);
		}
	}

	private AutomobileResponse(Builder builder) {
		this.id = builder.id;
		this.vehicleType = builder.vehicleType;
		this.fuelType = builder.fuelType;
		this.make = builder.make;
		this.model = builder.model;
		this.locality = builder.locality;
		this.city = builder.city;
		this.driven = builder.driven;
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

	public String getVehicleType() {
		return vehicleType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getLocality() {
		return locality;
	}

	public String getCity() {
		return city;
	}

	public String getDriven() {
		return driven;
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
