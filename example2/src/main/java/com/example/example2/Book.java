package com.example.example2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	private String title;
	private String ISBN;
	private int pages;

	public Book() {
		super();
	}

	public Book(String title, String ISBN, int pages) {
		super();
		this.title = title;
		this.ISBN = ISBN;
		this.pages = pages;
	}

	public Book(String title) {
		super();
		this.title = title;
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

	@Override
	public String toString() {
		return "Book [title=" + title + ", ISBN=" + ISBN + ", pages=" + pages + "]";
	}

}