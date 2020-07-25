package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.Product;
import com.ui.spring.springboot2jpacrudexample.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{

 
	@Autowired
	private ProductRepository  ProductRepository;
	
	@Override
	public List<Product> getAllProducts() {
		return this.ProductRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(Long productId) {
		return this.ProductRepository.findById(productId);
	}

	@Override
	public Product createProduct(Product product) {
		return this.ProductRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		return this.ProductRepository.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
		this.ProductRepository.delete(product);
	}
}
