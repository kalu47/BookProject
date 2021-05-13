package com.ust.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.book.model.Book;
import com.ust.book.repository.BookRepository;

@Service
public class RecomendationServiceImpl implements RecomendationService {

	@Autowired
	BookRepository bookRepo;
	
	
	/*
	 *
	 * 
	 */
	
	@Override
	public List<Book> getRecomendation(String id) {
		Book book = bookRepo.findById(id).get();
		List<Book> recomendations = new ArrayList<Book>();
		List<Book> allBooks = bookRepo.findAll();
		if (book != null) {
			List<String> subjects = book.getBookSubject();
			if (allBooks.size() > 1) {
				for (String s : subjects) {

					for (Book b : allBooks) {
						if (b.getBookSubject().contains(s) && !recomendations.contains(b) && !b.getbookId().equals(id)) {
							recomendations.add(b);
						}
					}
				}
			}
		}
		recomendations.sort((r1,r2) -> r1.getCount()>r2.getCount() ? -1:1);
		return recomendations;
	}

}
