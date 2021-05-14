package com.example.example3;

/*import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;*/
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

	
	
}