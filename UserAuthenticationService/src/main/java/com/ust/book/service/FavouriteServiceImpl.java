package com.ust.book.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.book.model.Book;
import com.ust.book.model.Favourite;
import com.ust.book.repository.FavouriteRepository;

@Service
public class FavouriteServiceImpl implements FavouriteService {

	@Autowired
	FavouriteRepository repo;
	
	/*
	 *
	 * 
	 */

	@Override
	public boolean saveFavourite(String userId) {
		try {
			Favourite f = new Favourite();
			f.setUserId(userId);
			f.setFavouriteBook(new ArrayList<Book>());
			repo.save(f);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	

}
