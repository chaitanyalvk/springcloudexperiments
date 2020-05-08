package com.chaitanyalvk.springcloudexperiments.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BookPagedList extends PageImpl<Book>{

	private static final long serialVersionUID = 1L;

	public BookPagedList(List<Book> content) {
		super(content);
	}
	
	public BookPagedList(List<Book> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

}
