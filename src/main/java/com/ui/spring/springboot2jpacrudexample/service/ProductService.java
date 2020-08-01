package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();

	Optional<Product> getProductById(Long productId);

	Product createProduct(Product product);	

	Product updateProduct(Product product);

	void deleteProduct(Product product);
	
	List<Product> getProductByCategory(Integer categoryId);
	
	
	
}
