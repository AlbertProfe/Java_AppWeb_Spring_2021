package com.example.exemple1;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping("/allbooks")
	public String showAllBooks(Model containerToView) {

		containerToView.addAttribute("booksfromController", bookService.queryBooks());
		//containerToView.addAttribute("fakebooksfromController", bookService.queryFakeBooks());

		return "library";
	}
	
	@RequestMapping("/newBook")
	public String newBook() {
		
		
		// some stuff to do: for exemple, validations, security,
		
		return "newBook";
	}

	
	  @RequestMapping("/addBook") public String insertBook(Book book, Model model)
	  {
	  
	  
	  bookService.queryAddBook(book);
	  
	  //model.addAttribute("booksfromController", bookService.queryBooks());
	  model.addAttribute("message", "your book is safe in our array list");
	  
	  String stringtosend = book.getTitle() + " - " + book.getAuthor();
	  model.addAttribute("bookCreated", stringtosend);
	  model.addAttribute("bookCreatedasObject", book);
	
	  model.addAttribute("serverTime", new Date());
	  
	 
	  
	  return "bookCreated"; }
	 
	
	/*
	 * @RequestMapping("/addBook") public String insertBook(Book book, Model model)
	 * {
	 * 
	 * 
	 * bookService.queryAddBook(book);
	 * 
	 * model.addAttribute("booksfromController", bookService.queryBooks());
	 * 
	 * 
	 * 
	 * return "library"; }
	 */

}




















