package com.example.exemple1;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping("/allBooks")
	public String showAllBooks(Model containerToView) {

		containerToView.addAttribute("booksfromController", bookService.queryBooks());
		// containerToView.addAttribute("fakebooksfromController",
		// bookService.queryFakeBooks());

		return "library";
	}

	@RequestMapping("/newBook")
	public String newBook() {

		// some stuff to do: for exemple, validations, security,

		return "newBook";
	}

	@RequestMapping("/addBook")
	public String insertBook(Book book, Model model) {

		bookService.queryAddBook(book);

		// model.addAttribute("booksfromController", bookService.queryBooks());
		model.addAttribute("message", "your book is safe in our array list");

		String stringtosend = book.getTitle() + " - " + book.getAuthor();
		model.addAttribute("bookCreated", stringtosend);
		model.addAttribute("bookCreatedasObject", book);

		model.addAttribute("serverTime", new Date());

		return "bookCreated";
	}

	@RequestMapping("/deleteBook")
	public String removeBook(@RequestParam("titleFromView") String titleToDelete, Model model) {

		// System.out.println(titleToDelete);
		// System.out.println(bookService.findBookByTitle(titleToDelete));

		// call to service

		if (bookService.findBookByTitle(titleToDelete) == -1) {
			return "bookNotFound";

		} else {

			List<Book> booksUpdated = bookService.queryDeleteBook(titleToDelete);
			model.addAttribute("booksfromController", booksUpdated);
			return "bookDeleted";
		}

		// System.out.println("array books in controller /n" +
		// bookService.queryBooks());

		// return "library";
	}

	@RequestMapping("/updateBook")
	public String updateBook(@RequestParam("titleFromView") String titleToUpdate, Model model) {

		int index = bookService.findBookByTitle(titleToUpdate);

		if (index == -1) {
			return "bookNotFound";

		} else {

			Book bookToUpdate = bookService.getBookByIndex(index);
			model.addAttribute("bookfromController", bookToUpdate);
			return "updateBook";
		}

		// System.out.println("array books in controller /n" +
		// bookService.queryBooks());

		// return "library";
	}

	@PostMapping("/replaceBook/{titleFromView}")
	public String replaceBook (@PathVariable("titleFromView") String titleToUpdate, Book book) {
		
		//System.out.println(titleToUpdate + "  " + book);
		int index = bookService.findBookByTitle(titleToUpdate);

		if (index == -1) {
			return "bookNotFound";

		} else {

			bookService.replaceBook(index, book);
			
			return "redirect:/books/allBooks";
		}

		
	}


}
