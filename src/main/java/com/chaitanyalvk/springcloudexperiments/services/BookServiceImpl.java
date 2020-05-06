package com.chaitanyalvk.springcloudexperiments.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.chaitanyalvk.springcloudexperiments.model.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookServiceImpl implements BookService {

	@Override
	public Book getBookById(UUID bookId) {
		return Book.builder().id(bookId)
				.author("LVKC")
				.title("SpringMeNow")
				.isbn("2020-04-28-CRN-TIMES")
				.build();
	}

	@Override
	public Book addBook(Book book) {
		
		return Book.builder().id(book.getId())
				.author(book.getAuthor())
				.title(book.getTitle())
				.isbn(book.getIsbn())
				.build();
		
	}

	@Override
	public void updateBook(UUID bookId, Book book) {
		
	}

	@Override
	public void deleteBook(UUID bookId) {
		log.debug("Deleted Book by id - " + bookId);
		
	}

}
