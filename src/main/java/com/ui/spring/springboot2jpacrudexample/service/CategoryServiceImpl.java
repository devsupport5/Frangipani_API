package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.Category;
import com.ui.spring.springboot2jpacrudexample.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

 
	@Autowired
	private CategoryRepository  categoryRepository;
	
	@Override
	public List<Category> getAllCategorys() {
		return this.categoryRepository.getAllCategorys();
	}

	@Override
	public Optional<Category> getCategoryById(Long categoryId) {
		return this.categoryRepository.findById(categoryId);
	}

	@Override
	public Category createCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Category category) {
		this.categoryRepository.delete(category);
	}

	@Override
	public List<Category> getSubCategorys(Integer categoryId) {
		// TODO Auto-generated method stub
		return this.categoryRepository.getSubCategorys(categoryId);
	}

	@Override
	public List<Category> getActiveCategory() {
		// TODO Auto-generated method stub
		return this.categoryRepository.getActiveCategory();
	}

}
