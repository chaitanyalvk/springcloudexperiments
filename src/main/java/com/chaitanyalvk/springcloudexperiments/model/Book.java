package com.chaitanyalvk.springcloudexperiments.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
	
	private UUID id;
	private String title;
	private String isbn;
	private String author;
	
	private double price;
	
	private OffsetDateTime publishedDate;
	
	private BookGenre genre;
	
}
