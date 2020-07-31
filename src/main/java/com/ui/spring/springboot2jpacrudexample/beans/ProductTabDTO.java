package com.ui.spring.springboot2jpacrudexample.beans;

import java.io.Serializable;

public class ProductTabDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private int productId;
	private String tabName;
	private String description;
	private int sequence;
	private int isActive;
	private String createdDate;
	
	public ProductTabDTO() {
		
	}

	 

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public String getTabName() {
		return tabName;
	}



	public void setTabName(String tabName) {
		this.tabName = tabName;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getSequence() {
		return sequence;
	}



	public void setSequence(int sequence) {
		this.sequence = sequence;
	}



	public int getIsActive() {
		return isActive;
	}



	public void setIsActive(int isActive) {
		this.isActive = isActive;
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
