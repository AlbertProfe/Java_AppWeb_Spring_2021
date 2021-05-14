package com.example.example4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class Example4Application {

	public static void main(String[] args) {
		SpringApplication.run(Example4Application.class, args);
	}
	
	
	

}
