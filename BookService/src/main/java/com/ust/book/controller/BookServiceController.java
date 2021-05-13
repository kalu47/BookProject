package com.ust.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.book.exception.BookAlreadyExistException;
import com.ust.book.exception.BookNotFoundException;
import com.ust.book.model.Book;
import com.ust.book.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api
@RequestMapping("/api/home/book")
public class BookServiceController {

	@Autowired
	BookService service;

	/*
	 *
	 * 
	 */
	
	@PutMapping("/save")
	@ApiOperation(value="Add a New Book to the Database")
	public ResponseEntity<?> saveBook(@RequestBody Book book,@RequestHeader(value = "authorization") String authHeader,@RequestHeader(value = "Knock_Knock") String adminHead) {
		try {
			if(!adminHead.equals("WONG The Book Keeper")) {
				return new ResponseEntity<String>("You are not the Book Keeper", HttpStatus.UNAUTHORIZED);
			}
			if (!service.saveBook(book)) {
				throw new Exception();
			}
			return new ResponseEntity<String>("Created", HttpStatus.CREATED);
		}catch (BookAlreadyExistException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	 *
	 * 
	 */
	
	@DeleteMapping("/delete/{bookId}")
	@ApiOperation(value="Deleta a book from the Database (If it exists)")
	public ResponseEntity<?> deleteBook(@PathVariable String bookId,@RequestHeader(value = "authorization") String authHeader,@RequestHeader(value = "Knock_Knock") String adminHead) {
		try {
			if (!service.deleteBook(bookId)) {
				throw new Exception();
			}
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		}catch (BookNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
