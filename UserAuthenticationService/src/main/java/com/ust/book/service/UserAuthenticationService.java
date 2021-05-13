package com.ust.book.service;


import com.ust.book.exception.UserAlreadyExistException;
import com.ust.book.exception.UserUnauthorisedException;
import com.ust.book.model.User;

public interface UserAuthenticationService {

	public User checkIdAndPassword(String userId, String password) throws UserUnauthorisedException,Exception;

    boolean registerUser(User user) throws UserAlreadyExistException,Exception;
    
}
