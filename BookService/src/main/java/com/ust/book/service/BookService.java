package com.ust.book.service;

import com.ust.book.exception.BookAlreadyExistException;
import com.ust.book.exception.BookNotFoundException;
import com.ust.book.model.Book;

public interface BookService {

	boolean saveBook(Book book) throws BookAlreadyExistException,Exception;

	boolean deleteBook(String id) throws BookNotFoundException,Exception;
}