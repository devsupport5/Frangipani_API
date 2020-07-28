package com.ui.spring.springboot2jpacrudexample.beans;

import java.io.Serializable;

public class OrderDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String orderNumber;
	private String orderStatus;
	private String payeeName;
	private String emailAddress;
	private String contactNumber;
	private String billerName;
	private String billerEmail;
	private String billerAddress1;
	private String billerAddress2;
	private String billerCountry;
	private String billerRegion;
	private String billerZipcode;
	private double amount;
	private String currencyType;
	private String paymentMethod;
	private String transactionNumber;
	private String cardName;
	private String bankName;
	private String otherInformation;
 	private String createdDate;
	 
	
	public OrderDTO() {
		
	}


	 

	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getOrderNumber() {
		return orderNumber;
	}




	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}




	public String getOrderStatus() {
		return orderStatus;
	}




	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}




	public String getPayeeName() {
		return payeeName;
	}




	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}




	public String getEmailAddress() {
		return emailAddress;
	}




	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}




	public String getContactNumber() {
		return contactNumber;
	}




	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}




	public String getBillerName() {
		return billerName;
	}




	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}




	public String getBillerEmail() {
		return billerEmail;
	}




	public void setBillerEmail(String billerEmail) {
		this.billerEmail = billerEmail;
	}




	public String getBillerAddress1() {
		return billerAddress1;
	}




	public void setBillerAddress1(String billerAddress1) {
		this.billerAddress1 = billerAddress1;
	}




	public String getBillerAddress2() {
		return billerAddress2;
	}




	public void setBillerAddress2(String billerAddress2) {
		this.billerAddress2 = billerAddress2;
	}




	public String getBillerCountry() {
		return billerCountry;
	}




	public void setBillerCountry(String billerCountry) {
		this.billerCountry = billerCountry;
	}




	public String getBillerRegion() {
		return billerRegion;
	}




	public void setBillerRegion(String billerRegion) {
		this.billerRegion = billerRegion;
	}




	public String getBillerZipcode() {
		return billerZipcode;
	}




	public void setBillerZipcode(String billerZipcode) {
		this.billerZipcode = billerZipcode;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(double amount) {
		this.amount = amount;
	}




	public String getCurrencyType() {
		return currencyType;
	}




	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}




	public String getPaymentMethod() {
		return paymentMethod;
	}




	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}




	public String getTransactionNumber() {
		return transactionNumber;
	}




	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}




	public String getCardName() {
		return cardName;
	}




	public void setCardName(String cardName) {
		this.cardName = cardName;
	}




	public String getBankName() {
		return bankName;
	}




	public void setBankName(String bankName) {
		this.bankName = bankName;
	}




	public String getOtherInformation() {
		return otherInformation;
	}




	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
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
