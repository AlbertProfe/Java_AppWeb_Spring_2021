package com.example.example3;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "AUTHOR")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String country;
	
	//remember that mapperBy says that we need author field in Book Class
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Book> books  = new ArrayList<Book>();
	
	public Author() {}
	
	public Author(Long id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}
	//getter from Books List
	public List<Book> getBooks() {
		return books;
	}
	
	
	// SETTER from field books
	// BE CAREFUL this setter is customized
	// array books add a new book as parameter
	// there is a double SETTER
	// one in AUTHOR
	// second in BOOK to set an author to the book, the author in this case is THIS
	public void addBook(Book book) {
		this.books.add(book);
		book.setAuthor(this);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	

}
