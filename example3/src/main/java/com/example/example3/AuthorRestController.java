package com.example.example3;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi")
public class AuthorRestController {

	@Autowired
	AuthorRepository repository;
	
	@GetMapping("/Authors")
	public Iterable<Author> ListAuthors(){
		return repository.findAll();
		
	}
	
	@GetMapping("/Author/{id}")
	public Author FindAuthor(@PathVariable long id) {
		Optional<Author> author= repository.findById(id);
		
		if (author.isPresent()) {
			
			return author.get();
		}
		
		return null;
		
	}
	
	@PostMapping(path = "/AddAuthor", consumes = "application/json")
	public void insertAuthor (@RequestBody Author author) {
		repository.save(author);
		
	}
	
	@DeleteMapping("/deleteAuthor/{id}")
	public void DeleteAuthor (@PathVariable long id) {
		Optional<Author> author = repository.findById(id);
		if (author.isPresent()) {
			repository.deleteById(id);
		}

	}
	@PutMapping("/UpdateAuthor/{id}")
	public void upAuthor ( @RequestBody Author author , @PathVariable long id) {
		Optional<Author> authorById = repository.findById(id);
		
		if(authorById.isPresent()) {
			repository.deleteById(id);
		}
		repository.save(author);
		
	}
}