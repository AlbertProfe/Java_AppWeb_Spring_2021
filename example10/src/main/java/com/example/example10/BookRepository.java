package com.example.example10;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,String> {
	
}