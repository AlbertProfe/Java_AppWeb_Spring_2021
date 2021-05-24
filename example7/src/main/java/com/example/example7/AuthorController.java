package com.example.example7;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Author addAuthor(@RequestBody Author author) {
		return authorRepository.save(author);
	}

	@GetMapping
	public Iterable<Author> getAll() {
		return authorRepository.findAll();
	}

	@GetMapping(value = "getAuthor/{id}")
	public Optional<Author> getOne(@PathVariable String id) {
		return authorRepository.findById(id);
	}

	@PutMapping("/updateAuthor/{id}")
	public Author updateAuthor(@RequestBody Author author, @PathVariable String id) {
		Optional<Author> authorById = authorRepository.findById(id);

		if (authorById.isPresent()) {
			authorRepository.deleteById(id);
		}
		return authorRepository.save(author);

	}

	@DeleteMapping(value = "deleteAuthor/{id}")
	public ResponseEntity<Author> deleteAuthor(@PathVariable String id) {

		Optional<Author> author = authorRepository.findById(id);
		if (author.isPresent()) {
			authorRepository.deleteById(id);
			// return ResponseEntity.ok().build();
			return new ResponseEntity<Author>(HttpStatus.OK);
		}
		// return ResponseEntity.notFound().build();
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
}
