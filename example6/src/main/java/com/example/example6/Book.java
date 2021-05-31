package com.example.example6;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "books")
public class Book {
	@Getter
	@Setter
	@Id
	private String id;
	@Getter
	@Setter
	private String title;
	@Getter
	@Setter
	private String publisher;
	@Getter
	@Setter
	private int pages;

	public Book() {

	}

	/*
	 * public String getId() { return id; } public void setId(String id) { this.id =
	 * id; } public String getTitle() { return title; } public void setTitle(String
	 * title) { this.title = title; } public String getPublisher() { return
	 * publisher; } public void setPublisher(String publisher) { this.publisher =
	 * publisher; } public int getPages() { return pages; } public void setPages(int
	 * pages) { this.pages = pages; }
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publisher=" + publisher + ", pages=" + pages + "]";
	}

}
