package com.mcc.springrest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mcc.springrest.domain.Book;
import com.mcc.springrest.exception.BookNotFoundException;
import com.mcc.springrest.service.BookService;

@Controller
public class BookController {

	@Autowired BookService bookService;
	
	@RequestMapping( value="/books/{bookId}", method=RequestMethod.DELETE)
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void deleteBook( @PathVariable("bookId") Long bookId ){
		if( bookId > 3 ){
			throw new BookNotFoundException("Book was not found:"+bookId);
		}
		System.out.println("Book ID to delete:" + bookId);
		
	}
	
	@RequestMapping(value="/books", method=RequestMethod.PUT)
	public @ResponseBody Book updateBook( @RequestBody Book book ){
		System.out.println("Book posted:"+book.getTitle());
		return book;
	}
	
	@RequestMapping(value="/books", method=RequestMethod.POST)
	@ResponseStatus( value=HttpStatus.CREATED)
	public @ResponseBody Book addBook( @RequestBody Book book ){
		System.out.println("Book posted:"+book.getTitle());
		return book;
	}
	
	@RequestMapping( value="/books", method=RequestMethod.GET) 
	public @ResponseBody List<Book> getAllBooks(){
		return bookService.retrieveAllBooks();
	}
	
	@ExceptionHandler( BookNotFoundException.class )
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public void handleBookNotFound( BookNotFoundException e ){
		System.out.println("returning not found for book, exception:"+e.getMessage());
	}
	
}
