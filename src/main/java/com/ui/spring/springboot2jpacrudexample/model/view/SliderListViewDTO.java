package com.ui.spring.springboot2jpacrudexample.model.view;

import java.io.Serializable;

public class SliderListViewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String sliderName;
	/*private String description;*/
	private String createdDate;
	private String detailLink;
	private String buyNowLink; 
	private String title;
	private String subTitle;
	private int isActive;
	private int isDeleted;
	
	
	public SliderListViewDTO() {
		
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


	/*public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	 

	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}
*/

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

	public String getDetailLink() {
		return detailLink;
	}
	public void setDetailLink(String detailLink) {
		this.detailLink = detailLink;
	}

	public String getBuyNowLink() {
		return buyNowLink;
	}
	public void setBuyNowLink(String buyNowLink) {
		this.buyNowLink = buyNowLink;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	  
}
