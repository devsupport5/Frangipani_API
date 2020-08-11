package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.ProductTab;

public interface ProductTabService {
	
	List<ProductTab> getAllProductTabs(Integer productId);

	Optional<ProductTab> getProductTabById(Long productId);

	ProductTab createProductTab(ProductTab product);	

	ProductTab updateProductTab(ProductTab product);

	void deleteProductTab(ProductTab product);
	
	List<ProductTab> getActiveProductTabByProduct(Integer productId);
	
}
