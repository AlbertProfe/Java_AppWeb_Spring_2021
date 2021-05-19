package com.example.example4;

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
public class BookRestController {

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;

	@GetMapping("/allBooks")
	public Page<Book> findAll(Pageable pageable) {

		return bookRepository.findAll(pageable);
	}

	@GetMapping("/getBook/{id}")
	public Book findByTitle(@PathVariable Long id) {
		Optional<Book> bookByTitle = bookRepository.findById(id);

		if (bookByTitle.isPresent()) {

			return bookByTitle.get();
		}

		return null;
	}

	@PostMapping(path = "/author/{idAuhtor}/addBook", consumes = "application/json")
	public Book insertBookByAuthor(@PathVariable(value = "idAuhtor") Long idAuhtor, @Validated @RequestBody Book book) {

		Optional<Author> author = authorRepository.findById(idAuhtor);

		if (author.isPresent()) {
			book.setAuthor(author.get());
			return bookRepository.save(book);
		}

		return null;
	}

	@PostMapping(path = "/addBook", consumes = "application/json")
	public Book insertBook(@Validated @RequestBody Book book) {

		System.out.println(book);

		return bookRepository.save(book);

	}

	@DeleteMapping("/deleteBook/{id}")
	public void deleteBook(@PathVariable Long id) {

		bookRepository.deleteById(id);

	}

	@DeleteMapping("/author/{idAuhtor}/book/{idBook}")
	public ResponseEntity<HttpStatus>  deleteBookByAuhtor(@PathVariable(value = "idAuhtor") Long idAuhtor,
			@PathVariable(value = "idBook") Long idBook) {

		Optional<Author> authorById = authorRepository.findById(idBook);

		if (!authorById.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		Optional<Book> bookById = bookRepository.findById(idBook);

		if (bookById.isPresent()) {
			bookRepository.deleteById(idBook);
			return new ResponseEntity<>( HttpStatus.OK); 
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/author/{idAuhtor}/book/{idBook}")
	public ResponseEntity<Book> upadateBookByAuthor(@RequestBody Book book,
			@PathVariable(value = "idAuhtor") Long idAuhtor, @PathVariable(value = "idBook") Long idBook) {

		Optional<Author> authorById = authorRepository.findById(idBook);

		if (!authorById.isPresent())
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		Optional<Book> bookById = bookRepository.findById(idBook);

		if (bookById.isPresent()) {

			bookById.get().setPages(book.getPages());
			bookById.get().setISBN(book.getISBN());

			return new ResponseEntity<>(bookRepository.save(bookById.get()), HttpStatus.OK);
			// bookRepository.save(bookById.get());

		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/updateBook/{title}")
	public void upadateBook(@RequestBody Book book, @PathVariable Long id) {

		Optional<Book> bookByTitle = bookRepository.findById(id);

		if (bookByTitle.isPresent()) {

			bookByTitle.get().setPages(book.getPages());
			bookByTitle.get().setISBN(book.getISBN());

			bookRepository.save(bookByTitle.get());

		}

	}

}
