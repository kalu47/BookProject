package com.ust.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.book.model.Book;
import com.ust.book.service.SearchService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/home")
@Api
public class SearchServiceController {

	@Autowired
	private SearchService service;
	
	/*
	 *
	 * 
	 */
	
	@GetMapping("/search/{searchQuery}")
	public ResponseEntity<?> searchBook(@PathVariable String searchQuery) {
		try {
			List<Book> books = service.getBookByNameOrAuthor(searchQuery);
						
			return new ResponseEntity<List<Book>>(books, HttpStatus.FOUND);

		} catch (Exception e) {
			return new ResponseEntity<String>("No such book or Author exists", HttpStatus.NOT_FOUND);
		}
	}


}
