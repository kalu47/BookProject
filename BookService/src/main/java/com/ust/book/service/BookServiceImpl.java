package com.ust.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.book.exception.BookAlreadyExistException;
import com.ust.book.exception.BookNotFoundException;
import com.ust.book.model.Book;
import com.ust.book.repository.BookServiceRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookServiceRepository repo;
	
	/*
	 *
	 * 
	 */
	
	@Override
	public boolean saveBook(Book book) throws BookAlreadyExistException{
		if (repo.findById(book.getbookId()).isPresent()) {
			
			throw new BookAlreadyExistException("Book Already Exist");
			
		}
		repo.save(book);
		return Boolean.TRUE;
	}
	
	/*
	 *
	 * 
	 */
	
	@Override
	public boolean deleteBook(String id) throws BookNotFoundException {
		if (!repo.findById(id).isPresent()) {
			
			throw new BookNotFoundException("Book Not Found");
			
		}
		repo.deleteById(id);
		return Boolean.TRUE;
	}

}
