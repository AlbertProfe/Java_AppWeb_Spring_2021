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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BOOK")
public class Book extends AuditLibrary {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String title;
	@Column
	private String ISBN;
	@Column
	private int pages;
	
	// The side which doesn't have the mappedBy attribute is the owner: 
	//books is the owner and authors is inverse side
	//  Besides, this owner has JOINTABLE
	// so, books is the owner: it makes the tough job,
	// that is, create the Author_Book auxiliary table, assign table
	// auxiliary-assign table: foreign keys from books and authors
	// owner is book so joinColumns is idBook
	// inverse is auhtor so inverseJoinColumn is idAuthor
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(	name = "Author_Book",
				joinColumns = { @JoinColumn(name = "idBook") },
				inverseJoinColumns = {@JoinColumn(name = "idAuthor") })
	private List<Author> authors = new ArrayList<Author>();

	public Book() {
		super();
	}

	public Book(Long id, String title, String ISBN, int pages) {
		super();
		this.id = id;
		this.title = title;
		this.ISBN = ISBN;
		this.pages = pages;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String Title) {
		this.title = Title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", ISBN=" + ISBN + ", pages=" + pages + "]";
	}

}