package com.truplat.post;

import java.io.Serializable;
import java.sql.Date;

public class Post implements Serializable {
	
	private static final long serialVersionUID = 7550413365179481426L;

	private Integer id;
	private String title;
	private String primaryImage;
	private String categoryName;
	private boolean bookmarked;
	private String postedBy;	
	private String organization;
	private Date modifiedDate;
	
	public Post(Integer id, String title, String primaryImage, String categoryName, boolean bookmarked, String postedBy,
			String organization, Date modifiedDate) {
		super();
		this.id = id;
		this.title = title;
		this.primaryImage = primaryImage;
		this.categoryName = categoryName;
		this.bookmarked = bookmarked;
		this.postedBy = postedBy;
		this.organization = organization;
		this.modifiedDate = modifiedDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrimaryImage() {
		return primaryImage;
	}
	public void setPrimaryImage(String primaryImage) {
		this.primaryImage = primaryImage;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public boolean isBookmarked() {
		return bookmarked;
	}
	public void setBookmarked(boolean bookmarked) {
		this.bookmarked = bookmarked;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
