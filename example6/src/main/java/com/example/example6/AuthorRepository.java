package com.example.example6;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {}


