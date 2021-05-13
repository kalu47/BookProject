package com.ust.book.repository;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.book.model.Book;
import com.ust.book.model.Favourite;

@Repository
public interface FavouriteRepository extends MongoRepository<Favourite, String> {

	Favourite findByFavId(String id);

	List<Book> findByFavouriteBook(List<Book> favouriteBooks);
	
	Favourite findByUserId(String userId);

}
