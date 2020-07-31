package com.ui.spring.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_tab")
public class ProductTab {

	private long id;
	private Integer productId;
	private String tabName;
	private String description;
	private int sequence;
	private int isActive;
	private String createdDate;
	
	public ProductTab() {
		
	}
	
	public ProductTab(String description) {
		this.description = description;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "tab_name")
	public String getTabName() {
		return tabName;
	}
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}


	@Column(name = "product_id", columnDefinition = "integer default 0")
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}

	
	@Column(name = "tab_sequence")
	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	
	
	@Column(name = "is_active", columnDefinition = "integer default 0")
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	@Column(name = "cteated_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
