package com.example.example9;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
	
	 Optional<Book> findByTitle(String title);
	
}