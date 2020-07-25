package com.ui.spring.springboot2jpacrudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.Author;
import com.ui.spring.springboot2jpacrudexample.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	 
}
