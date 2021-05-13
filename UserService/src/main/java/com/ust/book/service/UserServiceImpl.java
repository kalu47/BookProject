package com.ust.book.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.book.exception.UserNotFoundException;
import com.ust.book.model.User;
import com.ust.book.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;
	
	/*
	 *
	 * 
	 */
	
	@Override
	public boolean deleteUser(String id) throws UserNotFoundException {
		try {
			repo.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new UserNotFoundException("User is not found");
		}

	}
	
	/*
	 *
	 * 
	 */
	
	@Override
	public User updateUser(String id, User user) throws UserNotFoundException {
		User u = repo.findById(id).get();
		if (u == null) {
			throw new UserNotFoundException("User is not found");
		} else {
			repo.deleteById(id);
			repo.save(u);
			return u;
		}

	}

	@Override
	public User getByUserId(String id) throws UserNotFoundException {
		User u = repo.findById(id).get();
		if (u != null) {
			return u;
		}
		throw new UserNotFoundException("User is not Found");
	}

}
