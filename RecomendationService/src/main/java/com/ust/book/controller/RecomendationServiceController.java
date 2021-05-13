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
import com.ust.book.service.RecomendationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping("/api/home/search/recomendation")
public class RecomendationServiceController {

	@Autowired
	private RecomendationService service;
	
	/*
	 *
	 * 
	 */
	
	@GetMapping("/getRecomendations/{bookId}")
	@ApiOperation(value = "Get The Recomendations for a book based on user Favourites")
	public ResponseEntity<?> getRecomendations(@PathVariable String bookId) {
		try {
			List<Book> recomendations = service.getRecomendation(bookId);

			if (recomendations.size() >= 0) {
				return new ResponseEntity<List<Book>>(recomendations, HttpStatus.OK);
			}
			return new ResponseEntity<String>("Not Many Recomendations related to this Book",
					HttpStatus.EXPECTATION_FAILED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Unexpected Error", HttpStatus.BAD_REQUEST);
		}
	}
}
