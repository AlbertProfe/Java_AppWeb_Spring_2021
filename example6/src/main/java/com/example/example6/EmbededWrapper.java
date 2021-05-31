package com.example.example6;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "embededWrapper")
public class EmbededWrapper {
	
	Author author;
	List<Book> books;

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	

}
