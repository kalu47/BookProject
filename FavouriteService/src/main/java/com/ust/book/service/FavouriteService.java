package com.ust.book.service;


import com.ust.book.exception.UserNotFoundException;
import com.ust.book.model.Book;
import com.ust.book.model.Favourite;

public interface FavouriteService {
	

	boolean deleteUserFavouriteBooks(String userId, Book book) ;

	boolean updateUserFavouriteBooks(String userId, Book book);

	Favourite getByFavId(String userId) throws UserNotFoundException;
	
	int getCount(String userId)throws UserNotFoundException;

	
}
