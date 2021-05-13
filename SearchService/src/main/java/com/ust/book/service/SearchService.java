package com.ust.book.service;

import java.util.List;

import com.ust.book.exception.NoBookFoundException;
import com.ust.book.model.Book;

public interface SearchService {

	List<Book> getBookByNameOrAuthor(String searchQuery) throws NoBookFoundException;
}
