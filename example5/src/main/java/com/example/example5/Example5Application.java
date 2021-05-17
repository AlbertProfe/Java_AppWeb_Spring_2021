package com.example.example5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class Example5Application {

	public static void main(String[] args) {
		SpringApplication.run(Example5Application.class, args);
	}
	
	
	

}
