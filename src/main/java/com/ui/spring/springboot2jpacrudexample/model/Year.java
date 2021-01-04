package com.ui.spring.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_year")
public class Year {

	private long id;
	private String bookStartDate;
	private String bookEndDate;
	private int isActive;
	private int isDeleted;
	private String createdDate;
	
	public Year() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "book_start_date")
	public String getBookStartDate() {
		return bookStartDate;
	}
	public void setBookStartDate(String bookStartDate) {
		this.bookStartDate = bookStartDate;
	}

	@Column(name = "book_end_date")
	public String getBookEndDate() {
		return bookEndDate;
	}
	public void setBookEndDate(String bookEndDate) {
		this.bookEndDate = bookEndDate;
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
}
