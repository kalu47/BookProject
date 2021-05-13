package com.ust.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.book.exception.UserNotFoundException;
import com.ust.book.model.User;
import com.ust.book.service.FavouriteService;
import com.ust.book.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/home/user")
@Api
public class UserController {

	UserService userService;
	FavouriteService favouriteService;
	
	@Autowired
	public UserController(UserService userService,FavouriteService favouriteService) {
		this.userService=userService;
		this.favouriteService=favouriteService;
	}
	
	/*
	 *
	 * 
	 */
	
	@DeleteMapping("/deleteUser/{userId}")
	@ApiOperation(value= "Delete A User")
	public ResponseEntity<?> deleteUser(@PathVariable String userId,@RequestHeader(value="authorization") String header) {
		try {

			final String token = header.substring(5);
			final Claims claims = Jwts.parser().setSigningKey("seceretLock").parseClaimsJws(token).getBody();
			if(!claims.getId().equals(userId)) {
				return new ResponseEntity<String>("you are "+userId+", not a practitioner of the Mystic Arts. You are an IMPOSTER", HttpStatus.UNAUTHORIZED);
			}
			favouriteService.deleteFavourite(userId);			
			userService.deleteUser(userId);
			return new ResponseEntity<String>("Your Account Has Been Deleted Sucessfully", HttpStatus.OK);
		} 
		catch(UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage()+"Not Allowed", HttpStatus.FORBIDDEN);
		}
	}
	
	/*
	 *
	 * 
	 */
	
	@PutMapping("/update/{userId}")
	@ApiOperation(value= "Update Details of an Existing User")
	public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody User user,@RequestHeader(value="authorization") String header) {
		try {
			final String token = header.substring(5);
			final Claims claims = Jwts.parser().setSigningKey("seceretLock").parseClaimsJws(token).getBody();
			if(!claims.getId().equals(userId)) {
				return new ResponseEntity<String>("you are "+userId+", not a practitioner of the Mystic Arts. You are an IMPOSTER", HttpStatus.UNAUTHORIZED);
			}
			userService.updateUser(userId, user);
			return new ResponseEntity<User>(user, HttpStatus.OK);

		}
		catch(UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("Not Allowed", HttpStatus.FORBIDDEN);

		}
	}
	
	/*
	 *
	 * 
	 */
	
	@GetMapping("/find/{userId}")
	@ApiOperation(value= "Find a User")
	public ResponseEntity<?> findUser(@PathVariable String userId,@RequestHeader(value="authorization") String header) {
		try {
			final String token = header.substring(5);
			final Claims claims = Jwts.parser().setSigningKey("seceretLock").parseClaimsJws(token).getBody();
			if(!claims.getId().equals(userId)) {
				return new ResponseEntity<String>("you are "+userId+", not a practitioner of the Mystic Arts. You are an IMPOSTER", HttpStatus.UNAUTHORIZED);
			}
			User user = userService.getByUserId(userId);
			return new ResponseEntity<User>(user, HttpStatus.OK);

		}catch(UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("No Such user Exists", HttpStatus.NO_CONTENT);

		}
	}


}
