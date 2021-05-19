package com.example.example9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public class BookFillingRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BookFillingRunner.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		
		//Faker faker = new Faker();

		//String name = faker.book().title();  
		//String firstName = faker.book().genre();
		
		
		
		bookRepository.deleteAll();
		

		bookRepository.save(new Book("Programming Java", "SGRWE-456WSFG-D", 125));
		bookRepository.save(new Book("Programming JS", "SGRWE-456WSFG-D", 239));
		bookRepository.save(new Book("Programming PHP", "ERF-3333SFG-D", 456));
		bookRepository.save(new Book("Programming react", "SGRWE-456WSFG-D", 125));
		bookRepository.save(new Book("Programming angualar", "SGRWE-456WSFG-D", 239));
		bookRepository.save(new Book("Programming unity", "ERF-3333SFG-D", 456));
		
		bookRepository.findAll().forEach((book) -> {
			logger.info("{}", book);
		});
	}
}
