package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{


	@Query("SELECT u FROM Category u WHERE u.parentId = 0 order by categoryName")
	List<Category> getAllCategorys();
	
	@Query("SELECT u FROM Category u WHERE u.parentId = ?1")
	List<Category> getSubCategorys(Integer categoryId);
	
	@Query("SELECT u FROM Category u WHERE u.parentId = 0 and u.isActive = 0 order by categoryName")
	List<Category> getActiveCategory();
	
	@Query("SELECT u FROM Category u WHERE u.parentId != 0 and u.isActive = 0 order by categoryName")
	List<Category> getAllSubCategorys();
	
}
