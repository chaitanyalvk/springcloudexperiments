package com.chaitanyalvk.springcloudexperiments.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.util.UUID;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.Is.*;

import com.chaitanyalvk.springcloudexperiments.model.Book;
import com.chaitanyalvk.springcloudexperiments.services.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

	@MockBean
	BookService bookService;
	
	@Autowired
	MockMvc mockmvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	Book validBook;
	
	@BeforeAll
	public void setup() {
		validBook = Book.builder().id(UUID.randomUUID()).
				author("LVKC").
				isbn("KAJKLFJA-q290q").
				title("Angabayo Times").
				build();
	}
	
	@Test
	public void getBook() throws Exception {
		given(bookService.getBookById(any(UUID.class))).willReturn(validBook);
		
		mockmvc.perform(get("/api/v1/book/" + validBook.getId().toString())
				.accept(org.springframework.http.MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id", is(validBook.getId().toString())))
		.andExpect(jsonPath("$.title", is(validBook.getTitle().toString())));
	}
	
	@Test
	public void handlePost() throws Exception {
		Book book = validBook;
		book.setId(null);
		
		Book savedBook = Book.builder().id(UUID.randomUUID()).title("New Book").build();
		
		String bookJSON = objectMapper.writeValueAsString(book);
		
		given(bookService.addBook(any())).willReturn(savedBook);
		
		mockmvc.perform(post("/api/book/v1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(bookJSON))
		.andExpect(status().isCreated());
		
	}
	
	@Test
	public void handleUpdate() throws Exception {
		
		Book book = validBook;
		String bookJSON = objectMapper.writeValueAsString(book);
		
		mockmvc.perform(put("/api/book/v1/" + book.getId().toString())
				.contentType(MediaType.APPLICATION_JSON)
				.content(bookJSON))
		.andExpect(status().isNoContent());
		
		then(bookService).should().updateBook(any(), any());
	}
}
