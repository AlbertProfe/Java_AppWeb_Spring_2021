package com.example.example5;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHOR")
public class Author extends AuditLibrary {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String country;

	// many-to-many mapped by authors, the association is bidirectional,
	// that is, many authors have many books
	// The side which doesn't have the mappedBy attribute is the owner:
	// books is the owner and authors is inverse side
	// all these in JAVA thanks to List<Book>
	@ManyToMany(mappedBy = "authors",
			cascade = CascadeType.PERSIST,
			fetch = FetchType.EAGER)
	private List<Book> books = new ArrayList<Book>();

	public Author() {
	}

	public Author(Long id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	// SETTER from field books
	// BE CAREFUL: this setter is customized
	// array books add a new book come by as parameter
	// there is a double SETTER in BOTH classes: author and book
	// one in AUTHOR, that is, to THIS author add one book
	// second in BOOK to set an author to the book,
	//the author in this case is THIS
	public void addBook(Book book) {
		books.add(book);
		book.getAuthors().add(this);
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
