package com.ui.spring.springboot2jpacrudexample.beans;

import java.io.Serializable;

public class CategoryDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String categoryName;
	private String description;
	private int parentId;
	private int isActive;
	private int isDeleted;
	private String createdDate;
	 
	
	public CategoryDTO() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public int getIsActive() {
		return isActive;
	}


	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}


	public int getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}


	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	  
}
