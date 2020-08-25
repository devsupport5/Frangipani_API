package com.ui.spring.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.ui.spring.springboot2jpacrudexample.beans.AuthorDTO;
import com.ui.spring.springboot2jpacrudexample.exception.ResourceNotFoundException;
import com.ui.spring.springboot2jpacrudexample.model.Author;
import com.ui.spring.springboot2jpacrudexample.model.view.AuthorListViewDTO;
import com.ui.spring.springboot2jpacrudexample.service.AuthorService;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@GetMapping("/authors")
	public List<AuthorDTO> getAllauthors() {
		List<Author> authors = authorService.getAllAuthors();
		return authors.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@GetMapping("/authors/authorList")
	public List<AuthorListViewDTO> getAuthorList() {
		List<Author> authors = authorService.getAllAuthors();
		return authors.stream().map(this::convertToViewDto).collect(Collectors.toList());
	}
	
	
	@GetMapping("/authors/activeList")
	public List<AuthorDTO> getAuthorsActiveList() {
		List<Author> authors = authorService.getActiveAuthors();
		return authors.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@GetMapping("/authors/{id}")
	public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable(value = "id") Long authorId) {
		Author author = authorService.getAuthorById(authorId).get();
		return ResponseEntity.ok().body(convertToDto(author));
	}

	@PostMapping("/authors")
	public Author createAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
		return authorService.createAuthor(convertToEntity(authorDTO));
	}

	@PutMapping("/authors/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") Long authorId,
			@Valid @RequestBody Author AuthorDetails) throws ResourceNotFoundException {
		Author Author = authorService.getAuthorById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author not found for this id :: " + authorId));

		Author.setId(AuthorDetails.getId());
		Author.setAuthorName(AuthorDetails.getAuthorName());
		Author.setDescription(AuthorDetails.getDescription());
		Author.setIsActive(AuthorDetails.getIsActive());
		final Author updatedAuthor = authorService.updateAuthor(AuthorDetails);
		return ResponseEntity.ok(updatedAuthor);
	}

	@DeleteMapping("/authors/{id}")
	public Map<String, Boolean> deleteAuthor(@PathVariable(value = "id") Long authorId)
			throws ResourceNotFoundException {
		Author Author = authorService.getAuthorById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author not found for this id :: " + authorId));

		authorService.deleteAuthor(Author);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public AuthorListViewDTO convertToViewDto(Author author) {
		AuthorListViewDTO authorDTO = modelMapper.map(author, AuthorListViewDTO.class);
		return authorDTO;
	}
	
	public AuthorDTO convertToDto(Author author) {
		AuthorDTO authorDTO = modelMapper.map(author, AuthorDTO.class);
		return authorDTO;
	}
	
	public Author  convertToEntity(AuthorDTO authorDTO) {
		Author Author = modelMapper.map(authorDTO, Author.class);
		return Author;
	}
	
	 
}
