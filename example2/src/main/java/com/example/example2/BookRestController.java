package com.example.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/webapi")
public class BookRestController {

	@Autowired
	BookRepository repository;

	@GetMapping("/allBooks")
	public Iterable<Book> findAll() {
		
		return repository.findAll();
	}

	@PostMapping(path = "/addBook", consumes = "application/json")
	public void insertBook(@RequestBody Book book) {
		
		System.out.println(book);
		repository.save(book);	
	}
	
	@DeleteMapping("/deleteBook/{title}")
	public void deleteBook(@PathVariable String title) {
		
			repository.deleteById(title);
			
	}
	
	

}
