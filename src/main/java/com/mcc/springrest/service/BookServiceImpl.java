package com.mcc.springrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mcc.springrest.domain.Book;

@Component
public class BookServiceImpl implements BookService {

	@Override
	public Book retrieveBookById(Long id) {
		Book book = new Book();
		book.setId( id );
		book.setTitle("Fake Title with id:"+id);
		book.setAuthorName( "Fake Author for bookid:"+id);
		return book;
	}

	@Override
	public List<Book> retrieveAllBooks() {

		Book b1 = new Book( new Long(1), "Book1 Title", "Joe");
		Book b2 = new Book( new Long(2), "Book2 Title", "Sally");
		Book b3 = new Book( new Long(3), "Book3 Title", "Tim" );
		
		List<Book> books = new ArrayList<Book>(3);
		books.add(b1);books.add(b2);books.add(b3);
		
		return books;
		
	}

}
