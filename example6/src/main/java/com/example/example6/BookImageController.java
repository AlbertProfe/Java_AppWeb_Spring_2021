package com.example.example6;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Optional;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BookImageController {

	@Autowired
	private BookImageRepository bookImageRepository;

	@PostMapping("/bookImage")
	public BookImage addBookImage(@RequestParam String name, @RequestParam MultipartFile file) throws IOException {
		
		BookImage bookImage = new BookImage();
		bookImage.setName(name);
		bookImage.setImage(new Binary(file.getBytes()));

		return bookImageRepository.save(bookImage);
	}

	@GetMapping("/getBookImageData")
	public String getBookImageData(@RequestParam String id) {
		
		
		Optional<BookImage> bookImage = bookImageRepository.findById(id);
		Encoder encoder = Base64.getEncoder();

		return encoder.encodeToString(bookImage.get().getImage().getData());

	}

	@GetMapping("/getBookImage")
	public ResponseEntity<byte[]> getBookImage(@RequestParam String id) throws SQLException {
		
		Optional<BookImage> bookImage = bookImageRepository.findById(id);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    return new ResponseEntity<>(bookImage.get().getImage().getData(), headers, HttpStatus.OK);
		
		
	}

}
