package com.chaitanyalvk.springcloudexperiments.model;

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
	
	
}
