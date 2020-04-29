package com.chaitanyalvk.springcloudexperiments.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.chaitanyalvk.springcloudexperiments.model.Book;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public Book getBookById(UUID bookId) {
		return Book.builder().id(UUID.randomUUID())
				.author("LVKC")
				.title("SpringMeNow")
				.isbn("2020-04-28-CRN-TIMES")
				.build();
	}

}
