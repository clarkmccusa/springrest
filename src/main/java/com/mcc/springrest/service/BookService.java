package com.mcc.springrest.service;

import java.util.List;

import com.mcc.springrest.domain.Book;

public interface BookService {

	Book retrieveBookById( Long id );
	List<Book> retrieveAllBooks();
	
}
