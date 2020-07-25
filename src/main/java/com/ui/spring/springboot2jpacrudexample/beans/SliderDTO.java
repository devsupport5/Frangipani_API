package com.ui.spring.springboot2jpacrudexample.beans;

import java.io.Serializable;

public class SliderDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String sliderName;
	private String description;
	private String imagePath;	 
	private int isActive;
	private int isDeleted;
	private String createdDate;
	 
	
	public SliderDTO() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	
	public String getSliderName() {
		return sliderName;
	}


	public void setSliderName(String sliderName) {
		this.sliderName = sliderName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
