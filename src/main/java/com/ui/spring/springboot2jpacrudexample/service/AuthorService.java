package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import com.ui.spring.springboot2jpacrudexample.model.Author;

public interface AuthorService {
	
	List<Author> getAllAuthors();

	Optional<Author> getAuthorById(Long CategoryId);

	Author createAuthor(Author author);	

	Author updateAuthor(Author author);

	void deleteAuthor(Author author);
	
	List<Author> getActiveAuthors();
	
	
}
