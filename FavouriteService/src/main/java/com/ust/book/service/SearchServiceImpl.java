package com.ust.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.book.model.Book;
import com.ust.book.repository.SearchServiceRepository;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchServiceRepository repo;
	
	/*
	 *
	 * 
	 */
	
	@Override
	public Book getBookById(String bookId) {
		if (repo.findById(bookId).isPresent()) {
			return repo.findById(bookId).get();
		}
		return null;
	}

}
