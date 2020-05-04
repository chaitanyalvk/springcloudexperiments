package com.chaitanyalvk.springcloudexperiments.services;

import java.util.UUID;

import com.chaitanyalvk.springcloudexperiments.model.Book;

public interface BookService {

	Book getBookById(UUID bookId);

	Book addBook(Book book);

	void updateBook(UUID bookId, Book book);

}
