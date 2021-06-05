package exemple.exemple1client;

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

	@RequestMapping("/deleteBook")
	public String removeBook(@RequestParam("titleFromView") String titleToDelete, Model model) {

		bookService.queryDeleteBook(titleToDelete);
		return "redirect:/books/allBooks";
	}

	@RequestMapping("/newBook")
	public String newBook() {

		return "newBook";
	}

	@RequestMapping("/addBook")
	public String insertBook(Book book, Model model) {

		bookService.queryAddBook(book);

		return "redirect:/books/allBooks";
	}

	@RequestMapping("/updateBookForm")
	public String updateBook(@RequestParam("titleFromView") String titleToUpdate, Model model) {
		
		model.addAttribute("bookfromController", bookService.queryBook(titleToUpdate));
		return "updateBook";
	}

	@PostMapping("/updateBook/{titleFromView}")
	public String replaceBook(@PathVariable("titleFromView") String titleToUpdate, Book book) {
		
		bookService.queryUpdateBook(titleToUpdate, book);

		return "redirect:/books/allBooks";
	}

}
