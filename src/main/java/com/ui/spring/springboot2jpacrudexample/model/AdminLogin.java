package com.ui.spring.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_login")
public class AdminLogin {

	private long id;
	private String userName;
	private String password;
	 
	
	public AdminLogin() {
		
	}
	
	public AdminLogin(String categoryName, String description, String emailId) {
	 
		 
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	
	 

	@Column(name="password")
	public String getPassword() {
		return password;
	}

	@Column(name="user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	 


	 
 
}
