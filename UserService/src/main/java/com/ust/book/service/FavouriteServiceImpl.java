package com.ust.book.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public boolean deleteFavourite(String userId) {
		try {
			Favourite f = new Favourite();
			f = repo.findByUserId(userId);
			repo.delete(f);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	

}
