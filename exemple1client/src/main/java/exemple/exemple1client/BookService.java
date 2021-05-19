package exemple.exemple1client;

import org.springframework.web.client.RestTemplate;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BookService {
	
	
	RestTemplate template = new RestTemplate();
	
	
	public Iterable<Book> queryBooks() {
		
		ResponseEntity<List<Book>> response = template.exchange(
				"http://localhost:8081/webapi/allbooks",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Book>>(){});
		
		List<Book> books = response.getBody();
		
		
		return books;
		
		
	}

}
