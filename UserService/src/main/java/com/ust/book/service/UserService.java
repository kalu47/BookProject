package com.ust.book.service;

import com.ust.book.exception.UserNotFoundException;
import com.ust.book.model.User;

public interface UserService {

	boolean deleteUser(String userId) throws UserNotFoundException,Exception;
	
	User updateUser(String userId, User user)throws UserNotFoundException,Exception;
	
	User getByUserId(String userId)throws UserNotFoundException,Exception;
	
	
}
