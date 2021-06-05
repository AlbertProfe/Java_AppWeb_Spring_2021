package com.example.exemple1;


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
public class BookRestController {

	@Autowired
	BookService bookService;

	@GetMapping("/allBooks")
	public Iterable<Book> showAllBooks() {

		return bookService.queryBooks();
	}
	
	@GetMapping("/getBook/{title}")
	public Book getBook(@PathVariable String title) {
		
		//to-do getBookByTitle 
		 return bookService.getBookByIndex(bookService.findBookByTitle(title));  
	}

	@PostMapping(path = "/addBook", consumes = "application/json")
	public void insertBook(@RequestBody Book book) {

		bookService.queryAddBook(book);

	}

	@DeleteMapping("/deleteBook/{title}")
	public void deleteBook(@PathVariable String title) {

		if (bookService.findBookByTitle(title) != -1)
			bookService.queryDeleteBook(title);
		
	}
	
	@PutMapping("/updateBook/{title}")
	public void updateBook(@RequestBody Book book, @PathVariable String title) {

		int index = bookService.findBookByTitle(title);
	
		if (index != -1) {
			
			Book bookToReplace = bookService.getBookByIndex(index);
			
			if (book.getAuthor() != null) bookToReplace.setAuthor(book.getAuthor());
			if (book.getISBN() != null) bookToReplace.setISBN(book.getISBN());
			if (book.getPages() != 0) bookToReplace.setPages(book.getPages());
			if (book.getYear() != 0) bookToReplace.setYear(book.getYear());
			
			bookService.replaceBook(index,bookToReplace);
		}
	}
}
