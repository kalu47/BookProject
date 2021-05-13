package com.ust.book.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

	@Id
	private String bookId;
	private String bookTitle;
	private List<String> bookSubject;
	private String bookAuthor;
	private Date publishedYear;
	private long count;

	public Book() {
		super();
	}

	public Book(String bookId, String bookTitle, List<String> bookSubject, String bookAuthor, Date publishedYear) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookSubject = bookSubject;
		this.bookAuthor = bookAuthor;
		this.publishedYear = publishedYear;
	}

	public String getbookId() {
		return bookId;
	}

	public void setbookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public List<String> getBookSubject() {
		return bookSubject;
	}

	public void setBookSubject(List<String> bookSubject) {
		this.bookSubject = bookSubject;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Date getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(Date publishedYear) {
		this.publishedYear = publishedYear;
	}

	public long getCount() {
		return count;
	}

	public void incrementCount() {
		this.count = this.count + 1;
	}

	public void decrementCount() {
		if (this.count >= 0) {
			this.count = this.count - 1;
		}
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookSubject=" + bookSubject + ", bookAuthor="
				+ bookAuthor + ", publishedYear=" + publishedYear + "]";
	}

}
