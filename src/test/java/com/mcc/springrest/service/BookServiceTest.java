package com.mcc.springrest.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.mcc.springrest.domain.Book;

public class BookServiceTest {

	@Test
	public void returnsBookById(){
		BookService bookService = new BookServiceImpl();
		Book testBook = bookService.retrieveBookById(new Long(1));
		assertEquals( new Long(1), testBook.getId() );
		assertEquals( "Fake Title with id:1", testBook.getTitle());
		assertEquals( "Fake Author for bookid:1", testBook.getAuthorName());
	}
	
	@Test
	public void returnsListOfThree(){
		BookService bookService = new BookServiceImpl();
		List<Book> books = bookService.retrieveAllBooks();
		assertEquals(3, books.size());
	}
	
}
