package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.ProductTab;
import com.ui.spring.springboot2jpacrudexample.repository.ProductTabRepository;


@Service
public class ProductTabServiceImpl implements ProductTabService{

 
	@Autowired
	private ProductTabRepository  productTabRepository;
	
	@Override
	public List<ProductTab> getAllProductTabs(Integer productId) {
		return this.productTabRepository.getProductTabByProduct(productId);
	}

	@Override
	public Optional<ProductTab> getProductTabById(Long productId) {
		return this.productTabRepository.findById(productId);
	}

	@Override
	public ProductTab createProductTab(ProductTab product) {
		return this.productTabRepository.save(product);
	}

	@Override
	public ProductTab updateProductTab(ProductTab product) {
		return this.productTabRepository.save(product);
	}

	@Override
	public void deleteProductTab(ProductTab product) {
		this.productTabRepository.delete(product);
	}
	 
}
