package com.ust.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.book.model.Book;
import com.ust.book.service.FavouriteService;
import com.ust.book.service.SearchService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/home/user/favourite")
@Api
public class FavouriteServiceController {

	
	private FavouriteService favouriteService;
	private SearchService searchService;
	
	
	@Autowired
	public FavouriteServiceController(FavouriteService favouriteService,SearchService searchService){
		this.favouriteService=favouriteService;
		this.searchService=searchService;
	}
	
	/*
	 *
	 * 
	 */
	
	@PutMapping("/fav/addFavourite/{userId}")
	@ApiOperation(value = "Add a Book to Favourites")
	public ResponseEntity<?> addFavourite(@PathVariable String userId, @RequestBody Book book,
			@RequestHeader(value = "authorization") String header) {
		try {
			final String token = header.substring(5);
			final Claims claims = Jwts.parser().setSigningKey("seceretLock").parseClaimsJws(token).getBody();
			if(!claims.getId().equals(userId)) {
				return new ResponseEntity<String>("you are "+userId+", not a practitioner of the Mystic Arts. You are an IMPOSTER", HttpStatus.UNAUTHORIZED);
			}
			Book bookObj = searchService.getBookById(book.getbookId());
			int flag = 0;
			List<Book> u = favouriteService.getByFavId(userId).getFavouriteBook();

			for (Book obj : u) {
				if (obj.getbookId().equals(bookObj.getbookId())) {
					flag = 1;
					break;
				}
			}

			if (flag == 1) {
				favouriteService.deleteUserFavouriteBooks(userId, bookObj);
				return new ResponseEntity<String>("Removed form favourites", HttpStatus.OK);
			}
			favouriteService.updateUserFavouriteBooks(userId, bookObj);
			return new ResponseEntity<String>("Added to favourite", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage() + " " + book.getbookId() + " " + userId,
					HttpStatus.BAD_REQUEST);

		}
	}
	
	/*
	 *
	 * 
	 */
	
	@PostMapping("/fav/getCount/{userId}")
	@ApiOperation(value = "Get Total Favourite Count")
	public ResponseEntity<?> getTotalCount(@PathVariable String userId,
			@RequestHeader(value = "authorization") String header) {
		try {
			final String token = header.substring(5);
			final Claims claims = Jwts.parser().setSigningKey("seceretLock").parseClaimsJws(token).getBody();
			if(!claims.getId().equals(userId)) {
				return new ResponseEntity<String>("you are "+userId+", not a practitioner of the Mystic Arts. You are an IMPOSTER", HttpStatus.UNAUTHORIZED);
			}
			int count = favouriteService.getCount(userId);
			return new ResponseEntity<Integer>(count, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}


}
