package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
	@Query("SELECT u FROM Product u WHERE u.categoryId = ?1")
	List<Product> getProductByCategory(Long categoryId);
	 
	
	@Query("SELECT u FROM Product u WHERE u.isActive = 0 and u.isFeatured = 0")
	List<Product> getFeaturedProduct();
	
	@Query("SELECT u FROM Product u WHERE u.categoryId = ?1 and u.isActive = 0")
	List<Product> getActiveProductByCategory(Long categoryId);
	
	@Query("SELECT u FROM Product u WHERE u.id = ?1")
	Product getProductById(Long productId);
	
	@Query("SELECT u FROM Product u WHERE u.isActive = 0")
	List<Product> getActiveProducts();
	
}
