package com.example.example6;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authors")
public class Author {

	@Id
	private String id;
	@NotNull
	@Size(min=2, message="Name should be at least 5 characters")
	private String name;
	@NotNull
	@Size(min=2, message="Name should be at least 3 characters")
	private String surname;
	@Min(value=18, message="Age should be equal or greater than 18")  
    @Max(value=45, message="Age should be equal or less than 150")  
	private int age;
	private List<Book> books;
	
	
	public Author() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", books=" + books
				+ "]";
	}
	
	
	
	
	
	
	

}
