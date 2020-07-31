package com.ui.spring.springboot2jpacrudexample.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.IOUtils;
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

import com.ui.spring.springboot2jpacrudexample.beans.ProductTabDTO;
import com.ui.spring.springboot2jpacrudexample.exception.ResourceNotFoundException;
import com.ui.spring.springboot2jpacrudexample.model.ProductTab;
import com.ui.spring.springboot2jpacrudexample.service.ProductTabService;

@CrossOrigin
@RestController
@RequestMapping("/api/producttab")
public class ProductTabController {

	@Autowired
	ProductTabService productTabService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/producttabs/list/{id}")
	public List<ProductTabDTO> getAllProductTabs(@PathVariable(value = "id") Integer ProductId) {
		List<ProductTab> Products = productTabService.getAllProductTabs(ProductId);
		return Products.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@GetMapping("/producttabs/{id}")
	public ResponseEntity<ProductTabDTO> getProductTabById(@PathVariable(value = "id") Long ProductId) {
		ProductTab Product = productTabService.getProductTabById(ProductId).get();
		return ResponseEntity.ok().body(convertToDto(Product));
	}

	@PostMapping("/producttabs")
	public ProductTab createProduct(@Valid @RequestBody ProductTabDTO ProductTabDTO) {
		return productTabService.createProductTab(convertToEntity(ProductTabDTO));
	}

	@PutMapping("/producttabs/{id}")
	public ResponseEntity<ProductTab> updateProduct(@PathVariable(value = "id") Long ProductId,
			@Valid @RequestBody ProductTab ProductDetails) throws ResourceNotFoundException {
		ProductTab Product = productTabService.getProductTabById(ProductId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + ProductId));

		Product.setId(ProductDetails.getId());
		Product.setDescription(ProductDetails.getDescription());
		Product.setIsActive(ProductDetails.getIsActive());
		Product.setSequence(ProductDetails.getSequence());
		Product.setTabName(ProductDetails.getTabName());
		final ProductTab updatedProduct = productTabService.updateProductTab(ProductDetails);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/producttabs/{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long ProductId)
			throws ResourceNotFoundException {
		ProductTab Product = productTabService.getProductTabById(ProductId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + ProductId));

		productTabService.deleteProductTab(Product);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public ProductTabDTO convertToDto(ProductTab Product) {
		ProductTabDTO productTabDTO = modelMapper.map(Product, ProductTabDTO.class);
		return productTabDTO;
	}
	
	public ProductTab  convertToEntity(ProductTabDTO productTabDTO) {
		ProductTab Product = modelMapper.map(productTabDTO, ProductTab.class);
		return Product;
	}
	
	 
	
	 
}
