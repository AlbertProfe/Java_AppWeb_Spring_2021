package com.example.example5;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/*import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;*/
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

	Page<Book> findByAuthorId(Long id, Pageable pageable);
	
	
    Optional<Book> findByIdAndAuthorId(Long id, Long authorId);
	
}