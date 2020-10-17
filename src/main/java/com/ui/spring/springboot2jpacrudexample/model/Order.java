package com.ui.spring.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_order")
public class Order {

	private long id;
	private String orderNumber;
	private String orderStatus;
	private String paymentStatus;
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
 	private long  userId;
 	private String fullName;
	private String deliveryUserEmail;
	private String deliveryMobileNumber;
	private String deliveryAdd1;
	private String deliveryAdd2;
	private String deliveryCountry;
	private String deliveryState;
	private String deliveryCity;
	private String deliveryPinCode;
	private int orderQty;
 	private String paymentId;
 	private String PayerID;
 	private String paymentType;
	private String accountNumber;
	
	
	public Order() {
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "user_id", columnDefinition = "integer default 0")
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	@Column(name = "order_number")
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	@Column(name = "order_status")
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	@Column(name = "payee_name")
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	
	@Column(name = "email_address")
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	@Column(name = "contact_number")
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	@Column(name = "biller_name")
	public String getBillerName() {
		return billerName;
	}
	public void setBillerName(String billerName) {
		this.billerName = billerName;
	}
	
	@Column(name = "biller_email")
	public String getBillerEmail() {
		return billerEmail;
	}
	public void setBillerEmail(String billerEmail) {
		this.billerEmail = billerEmail;
	}
	
	@Column(name = "biller_address1")
	public String getBillerAddress1() {
		return billerAddress1;
	}
	public void setBillerAddress1(String billerAddress1) {
		this.billerAddress1 = billerAddress1;
	}
	
	@Column(name = "biller_address2")
	public String getBillerAddress2() {
		return billerAddress2;
	}
	public void setBillerAddress2(String billerAddress2) {
		this.billerAddress2 = billerAddress2;
	}
	
	@Column(name = "biller_country")
	public String getBillerCountry() {
		return billerCountry;
	}
	public void setBillerCountry(String billerCountry) {
		this.billerCountry = billerCountry;
	}
	
	@Column(name = "biller_region")
	public String getBillerRegion() {
		return billerRegion;
	}
	public void setBillerRegion(String billerRegion) {
		this.billerRegion = billerRegion;
	}
	
	@Column(name = "biller_zipcode")
	public String getBillerZipcode() {
		return billerZipcode;
	}
	public void setBillerZipcode(String billerZipcode) {
		this.billerZipcode = billerZipcode;
	}
	
	@Column(name = "biller_amount")
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Column(name = "currency_type")
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	
	@Column(name = "payment_method")
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Column(name = "transaction_number")
	public String getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
	@Column(name = "card_nmuber")
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	@Column(name = "bank_name")
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	@Column(name = "other_information")
	public String getOtherInformation() {
		return otherInformation;
	}
	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}
	@Column(name = "cteated_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "full_name")
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name = "delivery_user_email")
	public String getDeliveryUserEmail() {
		return deliveryUserEmail;
	}
	public void setDeliveryUserEmail(String deliveryUserEmail) {
		this.deliveryUserEmail = deliveryUserEmail;
	}
	 
	
	@Column(name = "delivery_mobile_number")
	public String getDeliveryMobileNumber() {
		return deliveryMobileNumber;
	}
	public void setDeliveryMobileNumber(String deliveryMobileNumber) {
		this.deliveryMobileNumber = deliveryMobileNumber;
	}
	
	@Column(name = "delivery_address1")
	public String getDeliveryAdd1() {
		return deliveryAdd1;
	}
	
	public void setDeliveryAdd1(String deliveryAdd1) {
		this.deliveryAdd1 = deliveryAdd1;
	}
	
	@Column(name = "delivery_address2")
	public String getDeliveryAdd2() {
		return deliveryAdd2;
	}
	public void setDeliveryAdd2(String deliveryAdd2) {
		this.deliveryAdd2 = deliveryAdd2;
	}
	
	@Column(name = "delivery_country")
	public String getDeliveryCountry() {
		return deliveryCountry;
	}
	public void setDeliveryCountry(String deliveryCountry) {
		this.deliveryCountry = deliveryCountry;
	}
	
	@Column(name = "delivery_state")
	public String getDeliveryState() {
		return deliveryState;
	}
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}
	
	@Column(name = "delivery_city")
	public String getDeliveryCity() {
		return deliveryCity;
	}
	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}
	
	@Column(name = "delivery_pincode")
	public String getDeliveryPinCode() {
		return deliveryPinCode;
	}
	public void setDeliveryPinCode(String deliveryPinCode) {
		this.deliveryPinCode = deliveryPinCode;
	}
	
	@Column(name = "order_qty")
	public int getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}
	
	@Column(name = "payment_id")
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	
	@Column(name = "payer_id")
	public String getPayerID() {
		return PayerID;
	}
	public void setPayerID(String payerID) {
		PayerID = payerID;
	}
	
	@Column(name="account_number")
	public String getAccountNumber() {
		return accountNumber;
	}

	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Column(name="payment_type")
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	@Column(name="payment_status")
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
}
