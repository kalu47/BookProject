package com.ust.book.service;

import java.util.List;

import com.ust.book.model.Book;

public interface RecomendationService {
	
	
	List<Book> getRecomendation(String id);
}
