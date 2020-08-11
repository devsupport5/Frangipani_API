package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.ProductTab;

@Repository
public interface ProductTabRepository extends JpaRepository<ProductTab, Long>{
	
	/*
	@Query("SELECT u FROM Product u WHERE u.categoryId = ?1")
	List<Product> getProductByCategory(Integer categoryId);*/
	
	@Query("SELECT u FROM ProductTab u WHERE u.productId = ?1")
	List<ProductTab> getProductTabByProduct(Integer productId);
	
	@Query("SELECT u FROM ProductTab u WHERE u.productId = ?1 and u.isActive = 0")
	List<ProductTab> getActiveProductTabByProduct(Integer productId);
	
}
