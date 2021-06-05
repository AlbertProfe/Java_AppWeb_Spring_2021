package exemple.exemple1client;

import org.springframework.web.client.RestTemplate;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	RestTemplate restTemplate = new RestTemplate();

	public List<Book> queryBooks() {

		ResponseEntity<List<Book>> response = restTemplate.exchange(
				"http://localhost:8081/webapi/allBooks",
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<Book>>() {
				});

		List<Book> books = response.getBody();

		return books;

	}

	public void queryDeleteBook(String titleToDelete) {

		restTemplate.delete("http://localhost:8081/webapi/deleteBook" + "/{titleToDelete}",
				titleToDelete);
	}

	public void queryAddBook(Book book) {

		restTemplate.postForObject("http://localhost:8081/webapi/addBook",
				book,
				Book.class);

	}

	public void queryUpdateBook(String title, Book book) {
		
		restTemplate.put("http://localhost:8081/webapi/updateBook" + "/{title}",
				book,
				title
				);

	}

	public Book queryBook(String titleToGet) {

		ResponseEntity<Book> response = restTemplate.getForEntity(
				"http://localhost:8081/webapi/getBook" + "/{titleToGet}",
				Book.class,
				titleToGet);

		Book book = response.getBody();

		return book;
	}

}
