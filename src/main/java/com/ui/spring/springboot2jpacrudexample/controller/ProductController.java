package com.ui.spring.springboot2jpacrudexample.controller;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ui.spring.springboot2jpacrudexample.beans.ProductDTO;
import com.ui.spring.springboot2jpacrudexample.exception.ResourceNotFoundException;
import com.ui.spring.springboot2jpacrudexample.model.Product;
import com.ui.spring.springboot2jpacrudexample.service.ProductService;

@CrossOrigin
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService ProductService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/products")
	public List<ProductDTO> getAllProducts() {
		List<Product> Products = ProductService.getAllProducts();
		return Products.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable(value = "id") Long ProductId) {
		Product Product = ProductService.getProductById(ProductId).get();
		return ResponseEntity.ok().body(convertToDto(Product));
	}

	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody ProductDTO productDTO) {
		return ProductService.createProduct(convertToEntity(productDTO));
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long ProductId,
			@Valid @RequestBody Product ProductDetails) throws ResourceNotFoundException {
		Product Product = ProductService.getProductById(ProductId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + ProductId));

		Product.setId(ProductDetails.getId());
		Product.setBookTitle(ProductDetails.getBookTitle());
		Product.setBindingType(ProductDetails.getBindingType());
		Product.setBookSKU(ProductDetails.getBookSKU());
		Product.setBookISNB(ProductDetails.getBookISNB());
		Product.setFeatured(ProductDetails.getFeatured());
		Product.setAuthorId(ProductDetails.getAuthorId());
		Product.setBookPrice(ProductDetails.getBookPrice());
		Product.setBookTaxes(ProductDetails.getBookTaxes());
		Product.setDescription(ProductDetails.getDescription());
		Product.setIsActive(ProductDetails.getIsActive());
		final Product updatedProduct = ProductService.updateProduct(ProductDetails);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/products/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long ProductId)
			throws ResourceNotFoundException {
		Product Product = ProductService.getProductById(ProductId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + ProductId));

		ProductService.deleteProduct(Product);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public ProductDTO convertToDto(Product Product) {
		ProductDTO ProductDTO = modelMapper.map(Product, ProductDTO.class);
		return ProductDTO;
	}
	
	public Product  convertToEntity(ProductDTO ProductDTO) {
		Product Product = modelMapper.map(ProductDTO, Product.class);
		return Product;
	}
	
	 
}
