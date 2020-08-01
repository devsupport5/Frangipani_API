package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.Category;

public interface CategoryService {
	
	List<Category> getAllCategorys();

	Optional<Category> getCategoryById(Long CategoryId);

	Category createCategory(Category category);	

	Category updateCategory(Category category);

	void deleteCategory(Category category);
	
	List<Category> getSubCategorys(Integer categoryId);
	
	List<Category> getActiveCategory();
}
