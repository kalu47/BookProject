package com.ust.book.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private String userPassword;
	private String email;
	private Date createdAt;
	
	
	public User() {
		setCreatedAt();
	}

	public User(String id, String firstName, String lastName, String password, String email) {
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userPassword = password;
		this.email = email;
	}
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String id) {
		this.userId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String password) {
		this.userPassword = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt() {
		this.createdAt = new Date();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", userPassword="
				+ userPassword + ", email=" + email + ", createdAt=" + createdAt + "]";
	}
	


}
