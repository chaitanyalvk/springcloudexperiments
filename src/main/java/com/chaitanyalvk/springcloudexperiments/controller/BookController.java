package com.chaitanyalvk.springcloudexperiments.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chaitanyalvk.springcloudexperiments.model.Book;
import com.chaitanyalvk.springcloudexperiments.services.BookService;

@RequestMapping("/api/v1/book")
@RestController
public class BookController {
	
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping({"/{bookId}"})
	public ResponseEntity<Book> getBook(@PathVariable("bookId")  UUID bookId) {
		return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		
		Book newBook = bookService.addBook(book);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Location", "/api/v1/book/" + newBook.getId().toString());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping({"/{bookId}"})
	public ResponseEntity<Book> updateBook(@PathVariable("bookId")  UUID bookId, @RequestBody Book book){
		
		bookService.updateBook(bookId, book);
		
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{bookId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBook(@PathVariable("bookId") UUID bookId) {
		bookService.deleteBook(bookId);
	}
}
 