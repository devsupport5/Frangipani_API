package com.ui.spring.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "register_user")
public class RegisterUser {

	private long id;
	private String yourName;
	private String contact;
	private String userEmail;
	private String userName;
	private String password;
	private int termsCondition;
	private int isActive;
	private int isDeleted;
	private String createdDate;
	
	public RegisterUser() {
	}
	
	public RegisterUser(String categoryName, String description, String emailId) {
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	 

	@Column(name = "your_name")
	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	@Column(name = "contact_number")
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "user_email")
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "is_active", columnDefinition = "integer default 0")
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	@Column(name = "is_deleted", columnDefinition = "integer default 0")
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "cteated_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "terms_condition", columnDefinition = "integer default 0")
	public int getTermsCondition() {
		return termsCondition;
	}

	public void setTermsCondition(int termsCondition) {
		this.termsCondition = termsCondition;
	}
	
	
	
}
