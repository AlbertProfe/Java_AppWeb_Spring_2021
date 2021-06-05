package com.example.exemple1;

//pojo Plain Old Java Object >>> bean
//there are four ways to configure spring:
// (1) xml and annotations are the main tools to manage the framework
//xml >> spring legacy (3.9), spring mvc (3.0) : web.xml, dispacherServelet, servelets
// (2) from spring (4.0) it spring boot, we use configuration java classes @configuration
// (3) all configurations >> annotations 
// (4) application.proporties yml
public class Book {

	private String title;
	private String ISBN;
	private int pages;
	private int year;
	private String author;

	public Book() {
		super();
	}

	public Book(String title, String ISBN, int pages) {
		super();
		this.title = title;
		this.ISBN = ISBN;
		this.pages = pages;
	}

	public Book(String title, String iSBN, int pages, int year, String author) {
		super();
		this.title = title;
		ISBN = iSBN;
		this.pages = pages;
		this.year = year;
		this.author = author;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", ISBN=" + ISBN + ", pages=" + pages + ", year=" + year + ", author=" + author
				+ "]";
	}
	
	

}
