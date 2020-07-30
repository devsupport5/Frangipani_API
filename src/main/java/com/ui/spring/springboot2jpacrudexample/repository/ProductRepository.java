package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.Author;
import com.ui.spring.springboot2jpacrudexample.model.Category;
import com.ui.spring.springboot2jpacrudexample.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
	@Query("SELECT u FROM Product u WHERE u.categoryId = ?1")
	List<Product> getProductByCategory(Integer categoryId);
}
