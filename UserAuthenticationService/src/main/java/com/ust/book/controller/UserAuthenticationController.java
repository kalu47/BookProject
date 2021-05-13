package com.ust.book.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ust.book.exception.UserAlreadyExistException;
import com.ust.book.exception.UserUnauthorisedException;
import com.ust.book.model.User;
import com.ust.book.service.FavouriteService;
import com.ust.book.service.UserAuthenticationService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/home/auth")
@Api
public class UserAuthenticationController {

	
	private UserAuthenticationService authenticationService;
	private FavouriteService favouriteService;
	
	@Autowired
	public UserAuthenticationController(UserAuthenticationService Service,FavouriteService favouriteService) {
		this.authenticationService = Service;
		this.favouriteService=favouriteService;
	}
	
	/*
	 *
	 * 
	 */
	
	@PutMapping("/register")//register new user
	@ApiOperation(value= "Register a new User")
	public ResponseEntity<String> register(@RequestBody User user) {
		try {
			if(!authenticationService.registerUser(user)) {
				throw new UserAlreadyExistException("user already exist");
			}
			
			favouriteService.saveFavourite(user.getUserId());
			
			return new ResponseEntity<String>("Created", HttpStatus.CREATED);
		}
		catch (UserAlreadyExistException u) {
			return new ResponseEntity<String>("user already exist", HttpStatus.CONFLICT);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	/*
	 *
	 * 
	 */
	
	@PostMapping("/login/{userId}/{userPassword}")//login checking
	@ApiOperation(value= "User Login")
	public ResponseEntity<String> login(@RequestParam String userId,@RequestParam String userPassword) {
		try {
			if(authenticationService.checkIdAndPassword(userId, userPassword) == null ) {
				throw new Exception();
			}
			return new ResponseEntity<String>("Doom "+getToken(userId, userPassword), HttpStatus.OK);
		} 
		catch (UserUnauthorisedException u) {
			return new ResponseEntity<String>("Wrong credentials", HttpStatus.UNAUTHORIZED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	 *
	 * 
	 */
	
	public String getToken(String username, String password) throws Exception {
		return Jwts.builder().setId(username).setSubject(password).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "seceretLock").compact();

	}
}
