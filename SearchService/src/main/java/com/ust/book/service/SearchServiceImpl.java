package com.ust.book.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.book.exception.NoBookFoundException;
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
    public List<Book> getBookByNameOrAuthor(String searchQuery) throws NoBookFoundException {

        List<Book> books = repo.findAll();
        List<Book> searchResult = new ArrayList<Book>();

        try {
            for (Book book : books) {
                if (book.getBookTitle().toLowerCase().startsWith(searchQuery.toLowerCase())
                         ||book.getBookAuthor().toLowerCase().startsWith(searchQuery.toLowerCase())
                         ||book.getBookTitle().toLowerCase().contains(searchQuery.toLowerCase())
                        || book.getBookAuthor().toLowerCase().contains(searchQuery.toLowerCase())) {
                    searchResult.add(book);
                }
            }
            if (searchResult.isEmpty()) {
                throw new NoBookFoundException("Book Not Found");
            }
            return searchResult;

        } catch (Exception e) {
            throw new NoBookFoundException("Book Not Found");
        }

    }

}