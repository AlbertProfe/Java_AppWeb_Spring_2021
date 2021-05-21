package com.example.example9;

import java.util.Random;

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

	
	public void run(String... args) throws Exception {

		String alphabetChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!·$%&/()=?¿?=)()/*-+^*Ç¨_:;;:_+/+/";

		//int i = 0;
		char stringRandom;
		/*
		 * while (i < 10) { char charRandom =
		 * alphabetChars.charAt(createIntRandom(alphabetChars.length())); 
		 * stringRandom * += stringRandom + charRandom;
		 * 
		 * }
		 */
		
		Faker faker = new Faker();
		Random rand = new Random();
		int max = 1525;
		int count = 1;

		//bookRepository.deleteAll();
		
		if (bookRepository.count()<0) {

		
					while (count < 50) {
			
						stringRandom = alphabetChars.charAt(createIntRandom(alphabetChars.length()));
						int intRandom = rand.nextInt(max);
						boolean randomPublished;
						if ((intRandom % 2) == 0) {
							randomPublished = true;
						} else {
							randomPublished = false;
						}
			
						bookRepository.save(new Book(
								faker.book().title(),
								faker.book().publisher(),
								String.valueOf((intRandom + 5) * count * 6) + stringRandom ,
								faker.book().genre(),
								intRandom + 10,
								randomPublished));
			
						count++;
					}
		
		}

		bookRepository.findAll().forEach((book) -> {
			logger.info("{}", book);
		});
	}

	public static int createIntRandom(int top) {

		Random rand = new Random();

		// Generate random integers in range 0 to top, if top=10 random 0 to 9
		int intRandom = rand.nextInt(top);
		return intRandom;

	}

}
