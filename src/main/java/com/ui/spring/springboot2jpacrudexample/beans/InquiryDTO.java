package com.ui.spring.springboot2jpacrudexample.beans;

import java.io.Serializable;

public class InquiryDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String fullName;
	private String message;
	private String emailAddress;
	private String contactNumber;
	private String createdDate;
	 
	
	public InquiryDTO() {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
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
