package com.ui.spring.springboot2jpacrudexample.beans;

import java.io.Serializable;
import java.sql.Blob;

import com.ui.spring.springboot2jpacrudexample.model.Currency;

public class ProductViewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private int categoryId;
	private int subCategoryId;
	private String bookTitle;
	private String description;
	private String bookSKU;
	private String bookISNB;
	private int authorId;
	private double bookPrice;
	private int currencyId;
	private double bookTaxes;
	private String bindingType;
	private String featured;
	private int parentId;
	private int isActive;
	private int isDeleted;
	private String createdDate;
	private int isFeatured; 
	private double originalPrice;
	private double discountedPrice;
	 
	 
	
	public ProductViewDTO() {
		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public int getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getBookSKU() {
		return bookSKU;
	}
	public void setBookSKU(String bookSKU) {
		this.bookSKU = bookSKU;
	}

	public String getBookISNB() {
		return bookISNB;
	}
	public void setBookISNB(String bookISNB) {
		this.bookISNB = bookISNB;
	}

	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}





	public double getBookPrice() {
		return bookPrice;
	}





	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public double getBookTaxes() {
		return bookTaxes;
	}
	public void setBookTaxes(double bookTaxes) {
		this.bookTaxes = bookTaxes;
	}

	public String getBindingType() {
		return bindingType;
	}
	public void setBindingType(String bindingType) {
		this.bindingType = bindingType;
	}

	public String getFeatured() {
		return featured;
	}
	public void setFeatured(String featured) {
		this.featured = featured;
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

	public int getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(int isFeatured) {
		this.isFeatured = isFeatured;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	  
}
