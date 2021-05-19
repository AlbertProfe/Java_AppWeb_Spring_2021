package com.example.example4;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/*import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;*/
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

	Page<Book> findByAuthorId(Long id, Pageable pageable);
	
	Page<Book> findAll(Pageable pageable);
    Optional<Book> findByIdAndAuthorId(Long id, Long authorId);
	
}