package com.mcc.springrest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mcc.springrest.domain.Book;
import com.mcc.springrest.service.BookService;

@Controller
public class BookController {

	@Autowired BookService bookService;
	
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
	
}
