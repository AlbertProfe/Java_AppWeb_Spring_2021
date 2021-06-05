package com.example.example9;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

//@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true", methods = {})
public class BookRestController {

	@Autowired
	BookRepository repository;
	@CrossOrigin(origins = "http://localhost:8081")
	@GetMapping("books")
	public Iterable<Book> findAll() {

		return repository.findAll();
	}

	@GetMapping("book/{id}")
	public Book findById(@PathVariable Long id) {

		Optional<Book> bookById = repository.findById(id);

		if (bookById.isPresent()) {

			return bookById.get();
		}

		return null;
	}

	@GetMapping("bookbytitle/{title}")
	public Book findByTitle(@PathVariable String title) {

		Optional<Book> bookByTitle = repository.findByTitle(title);

		if (bookByTitle.isPresent()) {

			return bookByTitle.get();
		}

		return null;
	}

	@PostMapping(path = "addBook", consumes = "application/json")
	public void createBook(@RequestBody Book book) {

		System.out.println(book);
		repository.save(book);
	}

	@DeleteMapping("deleteBook/{id}")
	public void removeBook(@PathVariable Long id) {

		repository.deleteById(id);

	}

	@DeleteMapping("deleteBooks")
	public void removeBooks() {

		repository.deleteAll();

	}

	@PutMapping("upadteBook/{id}")
	public void modifyBook(@RequestBody Book book, @PathVariable Long id) {

		Optional<Book> bookById = repository.findById(id);

		if (bookById.isPresent()) {

			bookById.get().setPages(book.getPages());
			bookById.get().setISBN(book.getISBN());
			bookById.get().setTitle(book.getTitle());
			bookById.get().setPublisher(book.getPublisher());
			bookById.get().setGenre(book.getGenre());
			bookById.get().setPublished(book.isPublished());
			

			repository.save(bookById.get());

		}

	}

}
