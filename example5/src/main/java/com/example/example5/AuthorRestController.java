package com.example.example5;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
	AuthorRepository authorRepository;

	@GetMapping("/allAuthors")
	public Page<Author> listAuthors(Pageable pageable) {
		return authorRepository.findAll(pageable);

	}

	@GetMapping("/author/{id}")
	public Author findAuthorById(@Validated @PathVariable Long id) {
		Optional<Author> author = authorRepository.findById(id);

		if (author.isPresent()) {
			return author.get();
		}
		return null;

	}

	@PostMapping(path = "/addAuthor", consumes = "application/json")
	public Author insertAuthor(@Validated @RequestBody Author author) {
		return authorRepository.save(author);

	}

	@DeleteMapping("/deleteAuthor/{id}")
	public ResponseEntity<Author> deleteAuthorById(@PathVariable Long id) {
		Optional<Author> author = authorRepository.findById(id);
		if (author.isPresent()) {
			authorRepository.deleteById(id);
			// return ResponseEntity.ok().build();
			return new ResponseEntity<Author>(HttpStatus.OK);
		}
		// return ResponseEntity.notFound().build();
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateAuthor/{id}")
	public Author upAuthor(@RequestBody Author author, @PathVariable Long id) {
		Optional<Author> authorById = authorRepository.findById(id);

		if (authorById.isPresent()) {
			authorRepository.deleteById(id);
		}
		return authorRepository.save(author);

	}
}