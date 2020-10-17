package com.ui.spring.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItems {

	private long orderItemId;
	private long orderId;
	private String bookTitle;
	private String categoryName;
	private String currencySymbol;
	private String authorName;
	private String image;
	private int qty;
	private int userId;
	private double price;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	@Column(name = "order_id", columnDefinition = "integer default 0")
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	@Column(name = "book_title")
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	@Column(name = "category_name")
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Column(name = "currency_symbol", columnDefinition = "LONGTEXT")
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	
	@Column(name = "author_name")
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
	@Column(name = "image", columnDefinition = "LONGTEXT")
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@Column(name = "order_qty")
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}