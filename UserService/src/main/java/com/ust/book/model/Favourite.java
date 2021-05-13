package com.ust.book.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Favourite {
	
	@Id
	private String favId;
	private String userId;
	private List<Book> favouriteBook = new ArrayList<Book>();
	
	public Favourite() {
		super();
	}

	public Favourite(String favId, String userId, List<Book> favouriteBook) {
		super();
		this.favId = favId;
		this.userId = userId;
		this.favouriteBook = favouriteBook;
	}

	public String getFavId() {
		return favId;
	}

	public void setFavId(String favId) {
		this.favId = favId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Book> getFavouriteBook() {
		return favouriteBook;
	}

	public void setFavouriteBook(List<Book> favouriteBook) {
		this.favouriteBook = favouriteBook;
	}

	@Override
	public String toString() {
		return "Favourite [favId=" + favId + ", userId=" + userId + ", favouriteBook=" + favouriteBook + "]";
	}
	
	

}
