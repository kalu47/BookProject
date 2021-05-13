package com.ust.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.book.exception.UserNotFoundException;
import com.ust.book.model.Book;
import com.ust.book.model.Favourite;
import com.ust.book.repository.BookRepository;
import com.ust.book.repository.FavouriteRepository;

@Service
public class FavouriteServiceImpl implements FavouriteService {

	
	FavouriteRepository repo;
	BookRepository bookRepo;
	@Autowired
	public FavouriteServiceImpl(FavouriteRepository repo,BookRepository bookRepo) {
		
		this.repo=repo;
		this.bookRepo=bookRepo;		
	}
	
	/*
	 *
	 * 
	 */
	
	@Override
    public Favourite getByFavId(String userId) throws UserNotFoundException {
        List<Favourite> u = repo.findAll();
        for(Favourite f : u ) {
            if(f.getUserId().equals(userId)) {
                return f;
            }
        }
        throw new UserNotFoundException("User is not Found");
    }
	
	/*
	 *
	 * 
	 */
	
	@Override
	public boolean updateUserFavouriteBooks(String userId, Book book) {
		Favourite u = repo.findByUserId(userId);
		u.getFavouriteBook().add(book);
		bookRepo.findById(book.getbookId()).get().incrementCount();
		repo.save(u);
		return true;
	}
	
	/*
	 *
	 * 
	 */
	
	@Override
	public boolean deleteUserFavouriteBooks(String userId, Book book) {
		Favourite u = repo.findByUserId(userId);
		for (Book b : u.getFavouriteBook()) {
			if (b.getbookId().equals(book.getbookId())) {
				u.getFavouriteBook().remove(u.getFavouriteBook().indexOf(b));
				bookRepo.findById(book.getbookId()).get().decrementCount();
				break;
			}
		}
		repo.save(u);
		return true;

	}
	/*
	 *
	 * 
	 */
	@Override
	public int getCount(String userId)throws UserNotFoundException {
		List<Favourite> u = repo.findAll();
		
        for(Favourite f : u ) {
            if(f.getUserId().equals(userId)) {
                return f.getFavouriteBook().size();
            }
        }
        throw new UserNotFoundException("User is not Found");
	}

	

}
