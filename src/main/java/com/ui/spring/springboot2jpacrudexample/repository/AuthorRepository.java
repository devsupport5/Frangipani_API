package com.ui.spring.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ui.spring.springboot2jpacrudexample.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

	@Query("SELECT u FROM Author u WHERE u.isActive = 0")
	List<Author> getActiveAuthors();
	
	
	
}
