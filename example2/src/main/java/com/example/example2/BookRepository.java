package com.example.example2;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,String> {
	
}