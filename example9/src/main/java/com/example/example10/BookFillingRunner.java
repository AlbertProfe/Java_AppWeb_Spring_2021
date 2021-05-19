package com.example.example10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookFillingRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(BookFillingRunner.class);

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		
		bookRepository.deleteAll();

		bookRepository.save(new Book("Orlando", "SGRWE-456WSFG-D", 125));
		bookRepository.save(new Book("To the lighthouse", "SGRWE-456WSFG-D", 239));
		bookRepository.save(new Book("Anna Karenina", "ERF-3333SFG-D", 456));
		
		bookRepository.findAll().forEach((book) -> {
			logger.info("{}", book);
		});
	}
}
