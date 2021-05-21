package com.example.example9;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Example9Application {

	public static void main(String[] args) {
		SpringApplication.run(Example9Application.class, args);
	}
}
