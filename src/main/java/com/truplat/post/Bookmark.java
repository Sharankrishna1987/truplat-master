package com.truplat.post;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.truplat.usermanagement.User;

@Entity
public class Bookmark {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private Integer postId;
	private String categoryName;
	@ManyToOne
	@JoinColumn(name="user_id")  
	private User user;
	private Date modifiedDate;	
	
	@SuppressWarnings("unused")
	private Bookmark(){}

	public Bookmark(Integer id, Integer postId, String categoryName, User user, Date modifiedDate) {
		super();
		this.id = id;
		this.postId = postId;
		this.categoryName = categoryName;
		this.user = user;
		this.modifiedDate = modifiedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}