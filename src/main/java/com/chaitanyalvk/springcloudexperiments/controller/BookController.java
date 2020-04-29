package com.chaitanyalvk.springcloudexperiments.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@GetMapping({"/bookId"})
	public ResponseEntity<Book> getBook(@PathVariable("bookId")  UUID bookId) {
		return new ResponseEntity<>(bookService.getBookById(bookId), HttpStatus.OK);
	}
}
 