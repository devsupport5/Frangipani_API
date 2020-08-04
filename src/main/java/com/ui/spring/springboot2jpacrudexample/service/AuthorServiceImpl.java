package com.ui.spring.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ui.spring.springboot2jpacrudexample.model.Author;
import com.ui.spring.springboot2jpacrudexample.repository.AuthorRepository;


@Service
public class AuthorServiceImpl implements AuthorService{

 
	@Autowired
	private AuthorRepository  authorRepository;
	
	@Override
	public List<Author> getAllAuthors() {
		return this.authorRepository.findAll();
	}

	@Override
	public Optional<Author> getAuthorById(Long AuthorId) {
		return this.authorRepository.findById(AuthorId);
	}

	@Override
	public Author createAuthor(Author Author) {
		return this.authorRepository.save(Author);
	}

	@Override
	public Author updateAuthor(Author Author) {
		return this.authorRepository.save(Author);
	}

	@Override
	public void deleteAuthor(Author Author) {
		this.authorRepository.delete(Author);
	}

	@Override
	public List<Author> getActiveAuthors() {
		// TODO Auto-generated method stub
		return this.authorRepository.getActiveAuthors();
	}

	 

}
