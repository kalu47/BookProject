package com.ust.book.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.book.model.Book;

@Repository
public interface BookServiceRepository extends MongoRepository<Book, String> {
	Book findByBookTitle(String searchQuery);

	List<Book> findByBookAuthor(String searchQuery);
}
