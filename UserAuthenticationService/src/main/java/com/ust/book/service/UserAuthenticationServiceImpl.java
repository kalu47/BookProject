package com.ust.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.book.exception.UserAlreadyExistException;
import com.ust.book.exception.UserUnauthorisedException;
import com.ust.book.model.User;
import com.ust.book.repository.UserAuthenticationRepository;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService{

	
	@Autowired
	UserAuthenticationRepository repository;

	public UserAuthenticationServiceImpl(UserAuthenticationRepository repository) {
		this.repository = repository;
	}
	
	/*
	 *
	 * 
	 */
	
	@Override
	public User checkIdAndPassword(String userId, String password) throws UserUnauthorisedException,Exception{
		User user=repository.findByUserIdAndUserPassword(userId, password);
		if(user == null) {
			throw new UserUnauthorisedException("Wrong Credentials"+userId+" "+password);
		}
		return user;
	}
	
	/*
	 *
	 * 
	 */
	
	@Override
	public boolean registerUser(User user)throws UserAlreadyExistException,Exception {
		try{
			if(repository.findById(user.getUserId()).isPresent()){
	
				throw new UserAlreadyExistException("User Already Exist");
			}
			repository.save(user);
			return Boolean.TRUE;
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	
	
	
	
}
