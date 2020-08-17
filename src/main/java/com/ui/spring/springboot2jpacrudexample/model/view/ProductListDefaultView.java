package com.ui.spring.springboot2jpacrudexample.model.view;

public class ProductListDefaultView {

	private long id;
	private long categoryId;
	private int subCategoryId;
	private String bookTitle;
	private String description;
	private String bookSKU;
	private String bookISNB;
	private long authorId;
	private double bookPrice;
	private int currencyId;
	private double bookTaxes;
	private String bindingType;
	private String featured;
	private int isActive;
	private int isDeleted;
	private int isFeatured;
	private String createdDate;
	private double originalPrice;
	private double discountedPrice;
	private String image;
	private String currencyName; 
	private String currencySymbol;
	
	public ProductListDefaultView() {
		
	}
	
	public ProductListDefaultView(String description) {
		this.description = description;
	}
	
	 
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
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

	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
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

	
	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	
	public int getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(int isFeatured) {
		this.isFeatured = isFeatured;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	 

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	
	
}
