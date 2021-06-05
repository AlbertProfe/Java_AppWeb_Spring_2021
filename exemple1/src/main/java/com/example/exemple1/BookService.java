package com.example.exemple1;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class BookService {

	static List<Book> books = new ArrayList<Book>();
	static List<Book> fakebooks = new ArrayList<Book>();

	static {
		Book book1 = new Book("Anna Karenina", "BASGA15-252S38", 568, 1872, "Leon Tolstoi");
		Book book2 = new Book("To The LightHouse", "BSDGA15-278912", 356, 1926, "Virginia Wolf");
		Book book3 = new Book("War and Peace", "BAgyg15-250092", 528, 1872, "Leon Tolstoi");
		Book book4 = new Book("Orlando", "yuplA15-340112", 356, 1926, "Virginia Wolf");
		Book book5 = new Book("Programming", "RETEWRT-340112", 356, 1926, "Engelbert");
		Book book6 = new Book("Programming api rest", "456-HDS-01246", 356, 1926, "Boris Omar");
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
	}

	/*
	 * public List<Book> fillArray() { Book book1 = new Book("Anna Karenina",
	 * "BASGA15-252S38", 568, 1872, "Leon Tolstoi"); Book book2 = new
	 * Book("To The LightHouse", "BSDGA15-278912", 356, 1926, "Virginia Wolf"); Book
	 * book3 = new Book("War and Peace", "BAgyg15-250092", 528, 1872,
	 * "Leon Tolstoi"); Book book4 = new Book("Orlando", "yuplA15-340112", 356,
	 * 1926, "Virginia Wolf"); Book book5 = new Book("Programming",
	 * "RETEWRT-340112", 356, 1926, "Engelbert"); Book book6 = new
	 * Book("Programming api rest", "4564564564646", 356, 1926, "Boris Omar");
	 * books.add(book1); books.add(book2); books.add(book3); books.add(book4);
	 * books.add(book5); books.add(book6);
	 * 
	 * 
	 * return books; }
	 */

	public List<Book> queryBooks() {

		// System.out.println("array books in controller querry/n" + this.books);
		return books;
	}

	public List<Book> queryFakeBooks() {

		int i = 0;
		Faker newfakebook = new Faker();

		while (i < 10000) {

			String author = newfakebook.book().author();
			String genre = newfakebook.book().genre();
			String title = newfakebook.book().title();

			fakebooks.add(new Book(title, genre, getRandomNumber(100, 1250), getRandomNumber(1800, 2021), author));
			i++;
		}

		return fakebooks;
	}

	public List<Book> queryDeleteBook(String title) {

		for (Book bookInArray : this.books) {

			if (bookInArray.getTitle().equals(title)) {
				this.books.remove(bookInArray);
				break;
			}

			// System.out.println("array books in service /n" + this.books);
			// if(books.indexOf(title)!=-1) books.remove(title);

		}
		return books;
	}

	public int findBookByTitle(String title) {

		/*
		 * int index = 0; for (Book bookInArray : this.books) { if
		 * (bookInArray.getTitle().equals(title)) break; index++; }
		 */

		int index = -1;

		for (Book bookInArray : this.books) {
			if (bookInArray.getTitle().equals(title)) {
				index = this.books.indexOf(bookInArray);
			}
		}
		return index;
	}

	public Book getBookByIndex(int index) {

		Book book = this.books.get(index);

		return book;
	}

	public boolean queryAddBook(Book newbooktoadd) {

		this.books.add(newbooktoadd);

		return true;

	}

	public void replaceBook(int index, Book book) {

		this.books.set(index, book);

	}

	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

}
