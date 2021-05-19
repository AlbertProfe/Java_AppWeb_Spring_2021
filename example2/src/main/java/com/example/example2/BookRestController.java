package com.example.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BookRestController {

	@Autowired
	BookRepository bookRepository;

	@GetMapping("/allBooks")
	public Iterable<Book> findAll() {
		
		return bookRepository.findAll();
	}

	@PostMapping(path = "/addBook", consumes = "application/json")
	public void insertBook(@RequestBody Book book) {
		bookRepository.save(book);
	}

}
